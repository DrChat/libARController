#!/usr/bin/env python

import sys
import os
import re
import argparse

PACKAGES_DIR=os.path.realpath(os.path.join(os.path.abspath(os.path.dirname(__file__)), '..', '..'))
sys.path.append('%(PACKAGES_DIR)s/ARSDKBuildUtils/Utils/Python' % locals())
sys.path.append('%(PACKAGES_DIR)s/libARCommands/Tools' % locals())
sys.path.append('%(PACKAGES_DIR)s/arsdk-xml' % locals())

import arsdkparser
from ARFuncs import *
from ARCommandsParser import *
from generateFeatureControllers import *
from generateDeviceControllers import *
from generateDictionaryKeyEnum import *

MYDIR=os.path.abspath(os.path.dirname(__file__))
DOC_DIR = os.path.join(MYDIR, 'documentation')
REF_DIR = os.path.join(MYDIR, 'reference')

MESSAGE_PATH = os.path.join(MYDIR, '..', '..', 'arsdk-xml', 'xml')

# Matches 111-22 or 111-222-3 between r'(#' and r')'
LINK_PATTERN = r'(?<=\(#)\d+(?:-\d+){1,2}(?=\))'

DEVICE_TO_STRING = {
    'drones': 'all drones',
    'rc':     'all remote controllers',
    'none':   'no product',
    '0900':   'Rolling Spider',
    '0901':   'Bebop',
    '0902':   'Jumping Sumo',
    '0903':   'SkyController',
    '0905':   'Jumping Night',
    '0906':   'Jumping Race',
    '0907':   'Airborne Night',
    '0909':   'Airborne Cargo',
    '090a':   'Hydrofoil',
    '090b':   'Mambo',
    '090c':   'Bebop 2',
    '090e':   'Disco',
    '090f':   'SkyController 2',
    '0910':   'Swing',
}
DEVICES_GLOBAL = [ 'drones', 'rc', 'none' ]
DEVICES_RC     = [ '0903', '090f' ]
DEVICES_DRONE  = [ x for x in DEVICE_TO_STRING if x not in (DEVICES_GLOBAL+DEVICES_RC) ]

BG_BLUE = '\033[00;44m'
BLUE =    '\033[00;94m'
GREEN =   '\033[00;92m'
PURPLE =  '\033[00;95m'
RED =     '\033[00;91m'
WHITE =   '\033[00;0m'
YELLOW =  '\033[00;93m'


##########################################################
#   Utils functions
##########################################################
def parse_features(ctx, xmlFolder):
    # first load generic.xml
    parse_xml(ctx, os.path.join(xmlFolder, 'generic.xml'))
    for f in sorted(os.listdir(xmlFolder)):
        if not f.endswith('.xml') or f == 'generic.xml':
            continue
        parse_xml(ctx, os.path.join(xmlFolder, f))

def format_message_name(feature, msg):
    msgName = get_ftr_old_name(feature) + '-'
    if msg.cls:
        msgName += msg.cls.name + '-'
    msgName += msg.name
    return msgName

def is_command_supported(cmd, product):
    if product is None:
        return True
    try:
        devices = [x.partition(':')[0] for x in cmd.doc.support.split(';')]
        if 'drones' in devices:
            return product in DEVICES_DRONE
        elif 'rc' in devices:
            return product in DEVICES_RC
        elif 'none' in devices:
            return False
        else:
            return product in devices
    except:
        return False


# Get the message link name (for example ARDrone3-Piloting-FlatTrim)
# formatted_id: the message id as entered in the comments.
#            for example 1-2-9 for messages from projects
#            or 134-2 for messages from features
def get_msg_name_from_formatted_id(formatted_id):
    part = formatted_id.group(0).split('-')
    project_id = int(part[0])
    feature = ctx.featuresById[int(project_id)]
    if len(part) == 2:
        message_id = int(part[1])
        msg = feature.getMsgsById()[message_id]
    elif len(part) == 3:
        class_id = int(part[1])
        message_id = int(part[2])
        project_class = feature.classesById[class_id]
        msg = project_class.cmdsById[message_id]
    return format_message_name(feature, msg)

# Get the support list as a formatted string
# supportStr: The support string as entered in the comments.
#             For example 0901;0902:3.2.0;090f
def getSupportListFormatted(supportStr):
    supportListFormatted = ''
    deviceList = supportStr.split(';')
    for device in deviceList:
        deviceDesc = device.split(':')
        supportListFormatted += '- *' + DEVICE_TO_STRING[deviceDesc[0]]
        if len(deviceDesc) > 1:
            supportListFormatted += ' since ' + deviceDesc[1]
        supportListFormatted += '*<br/>\n'

    if supportListFormatted:
        supportListFormatted += '\n\n'

    return supportListFormatted

# Return the given string where each id link (for example 134-2) is replaced by a link name
def replace_links(text):
    return re.sub(LINK_PATTERN, get_msg_name_from_formatted_id, text)

##########################################################
#   Write common doc functions
##########################################################

def write_message_header(docfile, feature, msg):
    docfile.write('<!-- ' + format_message_name(feature, msg) + '-->\n')
    docfile.write('### <a name="' + format_message_name(feature, msg) + '">')
    docfile.write(msg.doc.title)
    if msg.isDeprecated:
        docfile.write(' (deprecated)')
    docfile.write('</a><br/>\n')

def write_message_code_header(docfile, msg):
    docfile.write('> ' + msg.doc.title)
    if msg.isDeprecated:
        docfile.write(' (deprecated)')
    docfile.write(':\n\n')

def write_message_comment(docfile, msg, comment):
    if msg.isDeprecated:
        docfile.write('*This message is deprecated.*<br/>\n\n')
    for comment_line in comment.split('\n'):
        docfile.write(replace_links(comment_line) + '<br/>\n')
    docfile.write('\n\n')

def write_message_args(docfile, args):
    for arg in args:
        if isinstance(arg.argType, ArEnum):
            docfile.write ('* ' + arg.name + ' (' + 'enum' + '): ')
            for comm in arg.argType.doc.split('\n'):
                docfile.write (comm + '<br/>\n')

            for enum in arg.argType.values:
                docfile.write ('   * ' + enum.name + ': ')
                for enumCom in enum.doc.split('\n'):
                    docfile.write (enumCom + '<br/>\n')
        elif isinstance(arg.argType, ArBitfield):
            docfile.write ('* ' + arg.name + ' (' + 'bitfield as ' + ArArgType.TO_STRING[arg.argType.btfType] + '): ')
            for comm in arg.argType.enum.doc.split('\n'):
                docfile.write (comm + '<br/>\n')

            for enum in arg.argType.enum.values:
                docfile.write ('   * ' + enum.name + ': ')
                for enumCom in enum.doc.split('\n'):
                    docfile.write (enumCom + '<br/>\n')
        else:
            docfile.write ('* ' + arg.name + ' (' + ArArgType.TO_STRING[arg.argType] + '): ')
            for comm in arg.doc.split('\n'):
                docfile.write (comm + '<br/>\n')

def write_message_support(docfile, support):
    if support:
        docfile.write('\n\n')
        docfile.write('*Supported by <br/>*\n\n')
        docfile.write(getSupportListFormatted(support))

##########################################################
#   Write commands doc functions
##########################################################

# write the documentation of all commands of the given feature
def write_commands_doc(docfile, feature, product=None):
    ARPrint ('Feature ' + feature.name)


    for cmd in feature.cmds:
        if not is_command_supported(cmd, product):
            continue

        write_message_header(docfile, feature, cmd)

        write_message_code_header(docfile, cmd)

        write_command_c_code(docfile, feature, cmd)
        write_command_objc_code(docfile, feature, cmd)
        write_command_java_code(docfile, feature, cmd)

        write_message_comment(docfile, cmd, cmd.doc.desc)

        write_message_args(docfile, cmd.args)

        write_command_result(docfile, cmd.doc.result)

        write_message_support(docfile, cmd.doc.support)

        docfile.write('<br/>\n\n')

        if warning_mode:
            warning_str = ""
            if not cmd.doc.support and not cmd.isDeprecated:
                warning_str += '{}{}{}'.format(RED, "- Support list is missing\n", WHITE)

            if not cmd.doc.result and not cmd.isDeprecated:
                warning_str += '{}{}{}'.format(RED, "- Result is missing\n", WHITE)

            if len(cmd.doc.title) > 35:
                warning_str += '{}{}{}'.format(BLUE, "- Title too long\n", WHITE)

            if cmd.doc.support == 'none':
                warning_str += '{}{}{}'.format(BLUE, "- Support is none\n", WHITE)

            if warning_str:
                print(format_message_name(feature, cmd) + ":\n" + warning_str)

def write_command_c_code(docfile, feature, cmd):
    docfile.write('```c\n')
    docfile.write('deviceController->' + ARUncapitalize(get_ftr_old_name(feature)) + '->' + 'send' + ARCapitalize(format_cmd_name(cmd)) + '(deviceController->' + ARUncapitalize(get_ftr_old_name(feature)))
    for arg in cmd.args:
        docfile.write (', (' + xmlToC (MODULE_ARCOMMANDS, feature, cmd, arg) + ')' + arg.name)
    docfile.write(');\n')
    docfile.write('```\n\n')

def write_command_objc_code(docfile, feature, cmd):
    docfile.write('```objective_c\n')
    docfile.write('deviceController->' + ARUncapitalize(get_ftr_old_name(feature)) + '->' + 'send' + ARCapitalize(format_cmd_name(cmd)) + '(deviceController->' + ARUncapitalize(get_ftr_old_name(feature)))
    for arg in cmd.args:
        docfile.write (', (' + xmlToC (MODULE_ARCOMMANDS, feature, cmd, arg) + ')' + arg.name)
    docfile.write(');\n')
    docfile.write('```\n\n')

def write_command_java_code(docfile, feature, cmd):
    docfile.write('```java\n')
    docfile.write('deviceController.getFeature'+ ARCapitalize(get_ftr_old_name(feature)) + '().' + 'send' + ARCapitalize(format_cmd_name(cmd)) + '(')
    first = True
    for arg in cmd.args:
        if first:
            first = False
        else :
            docfile.write (', ')
        docfile.write ('(' + xmlToJava (MODULE_ARCOMMANDS, feature, cmd, arg) + ')' + arg.name + '')
    docfile.write(');\n')
    docfile.write('```\n')
    docfile.write('\n')

def write_command_result(docfile, result):
    if result:
        docfile.write ('\n\nResult:<br/>\n')
        for result_line in result.split('\n'):
            docfile.write(replace_links(result_line) + '<br/>\n')

##########################################################
#   Write events doc functions
##########################################################

# write the documentation of all events of the given feature
def write_events_doc(docfile, feature, product=None):
    for evt in feature.evts:
        if not is_command_supported(evt, product):
            continue

        write_message_header(docfile, feature, evt)

        write_message_code_header(docfile, evt)

        if evt.listType == ArCmdListType.LIST or evt.listType == ArCmdListType.MAP:
            write_event_list_c_code(docfile, feature, evt)
            write_event_list_objc_code(docfile, feature, evt)
            write_event_list_java_code(docfile, feature, evt)
        else:
            write_event_c_code(docfile, feature, evt)
            write_event_objc_code(docfile, feature, evt)
            write_event_java_code(docfile, feature, evt)

        write_message_comment(docfile, evt, evt.doc.desc)

        write_message_args(docfile, evt.args)

        write_event_triggered(docfile, evt.doc.triggered)

        docfile.write('<br/>\n\n')

        if warning_mode:
            warning_str = ""
            if not evt.doc.support and not evt.isDeprecated:
                warning_str += '{}{}{}'.format(RED, "- Support list is missing\n", WHITE)

            if not evt.doc.result and not evt.isDeprecated:
                warning_str += '{}{}{}'.format(RED, "- Result is missing\n", WHITE)

            if len(evt.doc.title) > 35:
                warning_str += '{}{}{}'.format(BLUE, "- Title too long\n", WHITE)

            if evt.doc.support == 'none':
                warning_str += '{}{}{}'.format(BLUE, "- Support is none\n", WHITE)

            if warning_str:
                print(format_message_name(feature, evt) + ":\n" + warning_str)

def write_event_list_c_code(docfile, feature, evt):
    docfile.write('```c\n')
    docfile.write('void onCommandReceived (eARCONTROLLER_DICTIONARY_KEY commandKey, ARCONTROLLER_DICTIONARY_ELEMENT_t *elementDictionary, void *customData)\n')
    docfile.write('{\n')
    docfile.write('    if ((commandKey == '+defineNotification(feature, evt)+') && (elementDictionary != NULL))\n')
    docfile.write('    {\n')
    if evt.args:
        docfile.write('        ARCONTROLLER_DICTIONARY_ARG_t *arg = NULL;\n')
        docfile.write('        ARCONTROLLER_DICTIONARY_ELEMENT_t *dictElement = NULL;\n')
        docfile.write('        ARCONTROLLER_DICTIONARY_ELEMENT_t *dictTmp = NULL;\n')
        docfile.write('        HASH_ITER(hh, elementDictionary, dictElement, dictTmp)\n')
        docfile.write('        {\n')
        for arg in evt.args:
            docfile.write('            HASH_FIND_STR (dictElement->arguments, '+defineNotification(feature, evt, arg)+', arg);\n')
            docfile.write('            if (arg != NULL)\n')
            docfile.write('            {\n')
            docfile.write('                '+xmlToC(MODULE_ARCOMMANDS, feature, evt, arg)+' '+arg.name+' = arg->value.')
            if isinstance(arg.argType, ArEnum):
                docfile.write (ARCapitalize('i32'))
            elif isinstance(arg.argType, ArBitfield):
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType.btfType]))
            else:
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType]))
            docfile.write(';\n')
            docfile.write('            }\n')
        docfile.write('        }\n')
    else:
        docfile.write('\n')
    docfile.write('    }\n')
    docfile.write('}\n')
    docfile.write('```\n\n')

def write_event_list_objc_code(docfile, feature, evt):
    docfile.write('```objective_c\n')
    docfile.write('void onCommandReceived (eARCONTROLLER_DICTIONARY_KEY commandKey, ARCONTROLLER_DICTIONARY_ELEMENT_t *elementDictionary, void *customData)\n')
    docfile.write('{\n')
    docfile.write('    if ((commandKey == '+defineNotification(feature, evt)+') && (elementDictionary != NULL))\n')
    docfile.write('    {\n')
    if evt.args:
        docfile.write('        ARCONTROLLER_DICTIONARY_ARG_t *arg = NULL;\n')
        docfile.write('        ARCONTROLLER_DICTIONARY_ELEMENT_t *dictElement = NULL;\n')
        docfile.write('        ARCONTROLLER_DICTIONARY_ELEMENT_t *dictTmp = NULL;\n')
        docfile.write('        HASH_ITER(hh, elementDictionary, dictElement, dictTmp)\n')
        docfile.write('        {\n')
        for arg in evt.args:
            docfile.write('            HASH_FIND_STR (dictElement->arguments, '+defineNotification(feature, evt, arg)+', arg);\n')
            docfile.write('            if (arg != NULL)\n')
            docfile.write('            {\n')
            docfile.write('                '+xmlToC(MODULE_ARCOMMANDS, feature, evt, arg)+' '+arg.name+' = arg->value.')
            if isinstance(arg.argType, ArEnum):
                docfile.write (ARCapitalize('i32'))
            elif isinstance(arg.argType, ArBitfield):
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType.btfType]))
            else:
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType]))
            docfile.write(';\n')
            docfile.write('            }\n')
        docfile.write('        }\n')
    else:
        docfile.write('\n')
    docfile.write('    }\n')
    docfile.write('}\n')
    docfile.write('```\n\n')

def write_event_list_java_code(docfile, feature, evt):
    docfile.write('```java\n')
    docfile.write('@Override\n')
    docfile.write('public void onCommandReceived (ARDeviceController deviceController, ARCONTROLLER_DICTIONARY_KEY_ENUM commandKey, ARControllerDictionary elementDictionary) {\n')
    docfile.write('    if ((commandKey == ARCONTROLLER_DICTIONARY_KEY_ENUM.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + ') && (elementDictionary != null)){\n')
    if evt.args:
        docfile.write('        Iterator<ARControllerArgumentDictionary<Object>> itr = elementDictionary.values().iterator();\n')
        docfile.write('        while (itr.hasNext()) {\n')
        docfile.write('            ARControllerArgumentDictionary<Object> args = itr.next();\n')
        docfile.write('            if (args != null) {\n')
        for arg in evt.args:
            if isinstance(arg.argType, ArEnum):
                docfile.write('                '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = ' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + '.getFromValue((Integer)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ '));\n')
            elif isinstance(arg.argType, ArBitfield):
                docfile.write('                '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')((Integer)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ')).intValue();\n')
            elif arg.argType == ArArgType.U8 or arg.argType == ArArgType.I8 or arg.argType == ArArgType.U16 or arg.argType == ArArgType.I16:
                docfile.write('                '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')((Integer)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ')).intValue();\n')
            elif arg.argType == ArArgType.FLOAT:
                docfile.write('                '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')((Double)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ')).doubleValue();\n')
            else:
                docfile.write('                '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ');\n')
        docfile.write('            }\n')
        docfile.write('        }\n')
    else:
        docfile.write('\n')
    docfile.write('    }\n')
    docfile.write('}\n')
    docfile.write('```\n\n')

def write_event_c_code(docfile, feature, evt):
    docfile.write('```c\n')
    docfile.write('void onCommandReceived (eARCONTROLLER_DICTIONARY_KEY commandKey, ARCONTROLLER_DICTIONARY_ELEMENT_t *elementDictionary, void *customData)\n')
    docfile.write('{\n')
    docfile.write('    if ((commandKey == '+defineNotification(feature, evt)+') && (elementDictionary != NULL))\n')
    docfile.write('    {\n')
    if evt.args:
        docfile.write('        ARCONTROLLER_DICTIONARY_ARG_t *arg = NULL;\n')
        docfile.write('        ARCONTROLLER_DICTIONARY_ELEMENT_t *element = NULL;\n')
        docfile.write('        HASH_FIND_STR (elementDictionary, ARCONTROLLER_DICTIONARY_SINGLE_KEY, element);\n')
        docfile.write('        if (element != NULL)\n')
        docfile.write('        {\n')
        for arg in evt.args:
            docfile.write('            HASH_FIND_STR (element->arguments, '+defineNotification(feature, evt, arg)+', arg);\n')
            docfile.write('            if (arg != NULL)\n')
            docfile.write('            {\n')
            docfile.write('                '+xmlToC(MODULE_ARCOMMANDS, feature, evt, arg)+' '+arg.name+' = arg->value.')
            if isinstance(arg.argType, ArEnum):
                docfile.write (ARCapitalize('i32'))
            elif isinstance(arg.argType, ArBitfield):
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType.btfType]))
            else:
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType]))
            docfile.write(';\n')
            docfile.write('            }\n')
        docfile.write('        }\n')
    else:
        docfile.write('\n')
    docfile.write('    }\n')
    docfile.write('}\n')
    docfile.write('```\n\n')


def write_event_objc_code(docfile, feature, evt):
    docfile.write('```objective_c\n')
    docfile.write('void onCommandReceived (eARCONTROLLER_DICTIONARY_KEY commandKey, ARCONTROLLER_DICTIONARY_ELEMENT_t *elementDictionary, void *customData)\n')
    docfile.write('{\n')
    docfile.write('    if ((commandKey == '+defineNotification(feature, evt)+') && (elementDictionary != NULL))\n')
    docfile.write('    {\n')
    if evt.args:
        docfile.write('        ARCONTROLLER_DICTIONARY_ARG_t *arg = NULL;\n')
        docfile.write('        ARCONTROLLER_DICTIONARY_ELEMENT_t *element = NULL;\n')
        docfile.write('        HASH_FIND_STR (elementDictionary, ARCONTROLLER_DICTIONARY_SINGLE_KEY, element);\n')
        docfile.write('        if (element != NULL)\n')
        docfile.write('        {\n')
        for arg in evt.args:
            docfile.write('            HASH_FIND_STR (element->arguments, '+defineNotification(feature, evt, arg)+', arg);\n')
            docfile.write('            if (arg != NULL)\n')
            docfile.write('            {\n')
            docfile.write('                '+xmlToC(MODULE_ARCOMMANDS, feature, evt, arg)+' '+arg.name+' = arg->value.')
            if isinstance(arg.argType, ArEnum):
                docfile.write (ARCapitalize('i32'))
            elif isinstance(arg.argType, ArBitfield):
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType.btfType]))
            else:
                docfile.write (ARCapitalize(ArArgType.TO_STRING[arg.argType]))
            docfile.write(';\n')
            docfile.write('            }\n')
        docfile.write('        }\n')
    else:
        docfile.write('\n')
    docfile.write('    }\n')
    docfile.write('}\n')
    docfile.write('```\n\n')

def write_event_java_code(docfile, feature, evt):
    docfile.write('```java\n')
    docfile.write('@Override\n')
    docfile.write('public void onCommandReceived (ARDeviceController deviceController, ARCONTROLLER_DICTIONARY_KEY_ENUM commandKey, ARControllerDictionary elementDictionary) {\n')
    docfile.write('    if ((commandKey == ARCONTROLLER_DICTIONARY_KEY_ENUM.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + ') && (elementDictionary != null)){\n')
    if evt.args:
        docfile.write('        ARControllerArgumentDictionary<Object> args = elementDictionary.get(ARControllerDictionary.ARCONTROLLER_DICTIONARY_SINGLE_KEY);\n')
        docfile.write('        if (args != null) {\n')
        for arg in evt.args:
            if isinstance(arg.argType, ArEnum):
                docfile.write('            '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = ' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + '.getFromValue((Integer)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ '));\n')
            elif isinstance(arg.argType, ArBitfield):
                docfile.write('            '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')((Integer)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ')).intValue();\n')
            elif arg.argType == ArArgType.U8 or arg.argType == ArArgType.I8 or arg.argType == ArArgType.U16 or arg.argType == ArArgType.I16:
                docfile.write('            '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')((Integer)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ')).intValue();\n')
            elif arg.argType == ArArgType.FLOAT:
                docfile.write('            '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')((Double)args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ')).doubleValue();\n')
            else:
                docfile.write('            '+ xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) +' ' + arg.name + ' = (' + xmlToJava(MODULE_ARCOMMANDS, feature, evt, arg) + ')args.get(' + javaFeatureClassName(feature) +'.ARCONTROLLER_DICTIONARY_KEY_' + get_ftr_old_name(feature).upper() + '_' + format_cmd_name(evt).upper() + '_' + arg.name.upper()+ ');\n')
        docfile.write('        }\n')
    else:
        docfile.write('\n')
    docfile.write('    }\n')
    docfile.write('}\n')
    docfile.write('```\n\n')

def write_event_triggered(docfile, triggered):
    if triggered:
        docfile.write ('\n\nTriggered ')
        for triggered_line in triggered.split('\n'):
            docfile.write(replace_links(triggered_line) + '<br/>\n\n')


##########################################################
#   Arg parsing
##########################################################
parser = argparse.ArgumentParser(description='Generate the documentation of messages.')
parser.add_argument('-f', '--features', nargs='*', type=str, metavar='feature',
                    help='List of features to generate the documentation. All features will be generated if missing.')
parser.add_argument('-w', '--warning', action='store_true',
                    help='Also generates warning logs if the feature does not contain new description or title too long or missing some tags.')
parser.add_argument('-r', '--reference', action='store_true',
                    help='Generate reference documentation for all products.')

args = parser.parse_args()

##########################################################
#   Main
##########################################################
warning_mode = args.warning

ctx = ArParserCtx()
parse_features(ctx, MESSAGE_PATH)

def _is_not_empty(path):
    try:
        return os.stat(path).st_size != 0
    except:
        return False

def _generate_doc(rootdir, features, product=None):
    if not os.path.exists(rootdir):
        os.makedirs(rootdir)

    has_events = dict()
    has_commands = dict()

    for feature in features:
        cmd_name = os.path.join(rootdir, '_commands_'+feature.name+'.md')
        with open(cmd_name, 'w') as f:
            write_commands_doc(f, feature, product=product)
        has_commands[feature.name] = _is_not_empty(cmd_name)

        evt_name = os.path.join(rootdir, '_events_'+feature.name+'.md')
        with open(evt_name, 'w') as f:
            write_events_doc(f, feature, product=product)
        has_events[feature.name] = _is_not_empty(evt_name)

    return (has_commands, has_events)

def _generate_toc(rootdir, cmds, evts, product):
    if not os.path.exists(rootdir):
        os.makedirs(rootdir)

    fname = os.path.join(rootdir, 'index.md')
    with open(fname, 'w') as f:
        f.write('---\n')
        try:
            f.write('title: libARController reference for %s\n' % DEVICE_TO_STRING[product])
        except KeyError:
            f.write('title: libARController reference for %s\n' % product)
        f.write('\n')
        f.write('language_tabs:\n')
        f.write('  - objective_c: Objective C\n')
        f.write('  - java: Java\n')
        f.write('  - c: C\n')
        f.write('\n')
        f.write('toc_footers:\n')
        f.write('  - <a href=\'http://forum.developer.parrot.com\'>Developer Forum</a>\n')
        f.write('  - <a href=\'https://github.com/Parrot-Developers/arsdk_manifest\'>See SDK sources</a>\n')
        f.write('  - <a href=\'http://github.com/tripit/slate\'>Documentation Powered by Slate</a>\n')
        f.write('\n')
        f.write('includes:\n')
        f.write('  - commands\n')
        for c in cmds:
            if cmds[c]:
                f.write('  - commands_' + c + '\n')
        f.write('  - events\n')
        for e in evts:
            if evts[e]:
                f.write('  - events_' + e + '\n')
        f.write('\n')
        f.write('search: true\n')
        f.write('---\n')


features = ctx.features if not args.features else [f for f in ctx.features if f.name in args.features]


if args.reference:
    products = ( x for x in DEVICE_TO_STRING if x not in (DEVICES_GLOBAL) )

    for p in products:
        name = DEVICE_TO_STRING[p].replace(' ', '_').lower()
        directory = os.path.join(REF_DIR, name)
        (cmds, evts) = _generate_doc(directory, features, product=p)
        _generate_toc(directory, cmds, evts, p)
    directory = os.path.join(REF_DIR, 'all')
    (cmds, evts) = _generate_doc(directory, features)
    _generate_toc(directory, cmds, evts, 'all products')

else:
    _generate_doc(DOC_DIR, features)

ARPrint('Done')
