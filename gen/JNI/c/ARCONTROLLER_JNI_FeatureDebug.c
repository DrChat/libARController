/**********************************************************
 *            AUTOGENERATED FILE                          *
 *             DO NOT MODIFY IT                           *
 *                                                        *
 * To add new commands :                                  *
 *  - Modify ../Xml/commands.xml file                     *
 *  - Re-run generateFeatureControllers.py script         *
 *                                                        *
 **********************************************************/

/**
* @file ARCONTROLLER_JNI_FeatureDebug
* @brief ARCONTROLLER_FEATURE_Debug_t JNI feature debug c file.
*/

/*****************************************
 *
 *             include file :
 *
 *****************************************/

#include <jni.h>
#include <stdlib.h>

#include <libARSAL/ARSAL_Print.h>

#include <libARController/ARCONTROLLER_Error.h>
#include <libARController/ARCONTROLLER_Feature.h>

/*****************************************
 *
 *             define :
 *
 *****************************************/

#define ARCONTROLLER_JNIFEATUREDEBUG_TAG "ARCONTROLLER_JNI_FeatureDebug"

/*****************************************
 *
 *             private header:
 *
 *****************************************/


/*****************************************
 *
 *             implementation :
 *
 *****************************************/

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoListFlags (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_LISTFLAGS);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoId (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_ID);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoLabel (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_LABEL);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoType (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_TYPE);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoMode (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_MODE);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoRangemin (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_RANGE_MIN);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoRangemax (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_RANGE_MAX);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoRangestep (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_RANGE_STEP);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsInfoValue (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSINFO_VALUE);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsListId (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSLIST_ID);
}

JNIEXPORT jstring JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeStaticGetKeyDebugSettingsListValue (JNIEnv *env , jclass class)
{
    return (*env)->NewStringUTF(env, ARCONTROLLER_DICTIONARY_KEY_DEBUG_SETTINGSLIST_VALUE);
}

JNIEXPORT jint JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeSendGetAllSettings (JNIEnv *env, jobject thizz, jlong jFeature)
{
    // local declarations
    ARCONTROLLER_FEATURE_Debug_t *nativeFeature = (ARCONTROLLER_FEATURE_Debug_t*) (intptr_t) jFeature;
    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    
    error = nativeFeature->sendGetAllSettings (nativeFeature);

    return error;
}

JNIEXPORT jint JNICALL
Java_com_parrot_arsdk_arcontroller_ARFeatureDebug_nativeSendSetSetting (JNIEnv *env, jobject thizz, jlong jFeature, jshort _id, jstring _value)
{
    // local declarations
    ARCONTROLLER_FEATURE_Debug_t *nativeFeature = (ARCONTROLLER_FEATURE_Debug_t*) (intptr_t) jFeature;
    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    const char *nativeValue = (*env)->GetStringUTFChars(env, _value, 0);
    
    error = nativeFeature->sendSetSetting (nativeFeature, _id, (char *)nativeValue);

    // cleanup
    (*env)->ReleaseStringUTFChars(env, _value, nativeValue);

    return error;
}

