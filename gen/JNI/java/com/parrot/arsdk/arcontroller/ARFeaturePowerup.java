/**********************************************************
 *            AUTOGENERATED FILE                          *
 *             DO NOT MODIFY IT                           *
 *                                                        *
 * To add new commands :                                  *
 *  - Modify ../Xml/commands.xml file                     *
 *  - Re-run generateDeviceControllers.py script          *
 *                                                        *
 **********************************************************/

/**
 * @file ARFeaturePowerup.java
 * @brief Feature controller allow to send command related of powerup Feature.
 * All commands specific to the Power Up.
 */
package com.parrot.arsdk.arcontroller;

import com.parrot.arsdk.arsal.ARSALPrint;
import com.parrot.arsdk.arcommands.*;
import com.parrot.arsdk.ardiscovery.ARDiscoveryDevice;

import java.util.List;
import java.util.ArrayList;

public class ARFeaturePowerup
{
    private static String TAG = "ARFeaturePowerup";
    
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ALERTSTATECHANGED_STATE = ""; /**< Key of the argument </code>state</code> of event <code>PilotingStateAlertStateChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_FLYINGSTATECHANGED_STATE = ""; /**< Key of the argument </code>state</code> of event <code>PilotingStateFlyingStateChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_MOTORMODECHANGED_MODE = ""; /**< Key of the argument </code>mode</code> of event <code>PilotingStateMotorModeChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ATTITUDECHANGED_ROLL = ""; /**< Key of the argument </code>roll</code> of event <code>PilotingStateAttitudeChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ATTITUDECHANGED_PITCH = ""; /**< Key of the argument </code>pitch</code> of event <code>PilotingStateAttitudeChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ATTITUDECHANGED_YAW = ""; /**< Key of the argument </code>yaw</code> of event <code>PilotingStateAttitudeChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ALTITUDECHANGED_ALTITUDE = ""; /**< Key of the argument </code>altitude</code> of event <code>PilotingStateAltitudeChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_SETTING = ""; /**< Key of the argument </code>setting</code> of event <code>PilotingSettingsStateSettingChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_CURRENT = ""; /**< Key of the argument </code>current</code> of event <code>PilotingSettingsStateSettingChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_MIN = ""; /**< Key of the argument </code>min</code> of event <code>PilotingSettingsStateSettingChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_MAX = ""; /**< Key of the argument </code>max</code> of event <code>PilotingSettingsStateSettingChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_PICTURESTATECHANGEDV2_STATE = ""; /**< Key of the argument </code>state</code> of event <code>MediaRecordStatePictureStateChangedV2</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_PICTURESTATECHANGEDV2_ERROR = ""; /**< Key of the argument </code>error</code> of event <code>MediaRecordStatePictureStateChangedV2</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_VIDEOSTATECHANGEDV2_STATE = ""; /**< Key of the argument </code>state</code> of event <code>MediaRecordStateVideoStateChangedV2</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_VIDEOSTATECHANGEDV2_ERROR = ""; /**< Key of the argument </code>error</code> of event <code>MediaRecordStateVideoStateChangedV2</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_PICTUREEVENTCHANGED_EVENT = ""; /**< Key of the argument </code>event</code> of event <code>MediaRecordEventPictureEventChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_PICTUREEVENTCHANGED_ERROR = ""; /**< Key of the argument </code>error</code> of event <code>MediaRecordEventPictureEventChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_VIDEOEVENTCHANGED_EVENT = ""; /**< Key of the argument </code>event</code> of event <code>MediaRecordEventVideoEventChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_VIDEOEVENTCHANGED_ERROR = ""; /**< Key of the argument </code>error</code> of event <code>MediaRecordEventVideoEventChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED_TYPE = ""; /**< Key of the argument </code>type</code> of event <code>NetworkSettingsStateWifiSelectionChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED_BAND = ""; /**< Key of the argument </code>band</code> of event <code>NetworkSettingsStateWifiSelectionChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED_CHANNEL = ""; /**< Key of the argument </code>channel</code> of event <code>NetworkSettingsStateWifiSelectionChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_SSID = ""; /**< Key of the argument </code>ssid</code> of event <code>NetworkStateWifiScanListChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_RSSI = ""; /**< Key of the argument </code>rssi</code> of event <code>NetworkStateWifiScanListChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_BAND = ""; /**< Key of the argument </code>band</code> of event <code>NetworkStateWifiScanListChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_CHANNEL = ""; /**< Key of the argument </code>channel</code> of event <code>NetworkStateWifiScanListChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED_BAND = ""; /**< Key of the argument </code>band</code> of event <code>NetworkStateWifiAuthChannelListChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED_CHANNEL = ""; /**< Key of the argument </code>channel</code> of event <code>NetworkStateWifiAuthChannelListChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED_IN_OR_OUT = ""; /**< Key of the argument </code>in_or_out</code> of event <code>NetworkStateWifiAuthChannelListChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_LINKQUALITYCHANGED_QUALITY = ""; /**< Key of the argument </code>quality</code> of event <code>NetworkStateLinkQualityChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIASTREAMINGSTATE_VIDEOENABLECHANGED_ENABLED = ""; /**< Key of the argument </code>enabled</code> of event <code>MediaStreamingStateVideoEnableChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_VIDEOSETTINGSSTATE_AUTORECORDCHANGED_ENABLED = ""; /**< Key of the argument </code>enabled</code> of event <code>VideoSettingsStateAutorecordChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_VIDEOSETTINGSSTATE_VIDEOMODECHANGED_MODE = ""; /**< Key of the argument </code>mode</code> of event <code>VideoSettingsStateVideoModeChanged</code> in feature <code>Powerup</code> */
    public static String ARCONTROLLER_DICTIONARY_KEY_POWERUP_SOUNDSSTATE_BUZZCHANGED_ENABLED = ""; /**< Key of the argument </code>enabled</code> of event <code>SoundsStateBuzzChanged</code> in feature <code>Powerup</code> */

    private static native String nativeStaticGetKeyPowerupPilotingStateAlertStateChangedState ();
    private static native String nativeStaticGetKeyPowerupPilotingStateFlyingStateChangedState ();
    private static native String nativeStaticGetKeyPowerupPilotingStateMotorModeChangedMode ();
    private static native String nativeStaticGetKeyPowerupPilotingStateAttitudeChangedRoll ();
    private static native String nativeStaticGetKeyPowerupPilotingStateAttitudeChangedPitch ();
    private static native String nativeStaticGetKeyPowerupPilotingStateAttitudeChangedYaw ();
    private static native String nativeStaticGetKeyPowerupPilotingStateAltitudeChangedAltitude ();
    private static native String nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedSetting ();
    private static native String nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedCurrent ();
    private static native String nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedMin ();
    private static native String nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedMax ();
    private static native String nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedListflags ();
    private static native String nativeStaticGetKeyPowerupMediaRecordStatePictureStateChangedV2State ();
    private static native String nativeStaticGetKeyPowerupMediaRecordStatePictureStateChangedV2Error ();
    private static native String nativeStaticGetKeyPowerupMediaRecordStateVideoStateChangedV2State ();
    private static native String nativeStaticGetKeyPowerupMediaRecordStateVideoStateChangedV2Error ();
    private static native String nativeStaticGetKeyPowerupMediaRecordEventPictureEventChangedEvent ();
    private static native String nativeStaticGetKeyPowerupMediaRecordEventPictureEventChangedError ();
    private static native String nativeStaticGetKeyPowerupMediaRecordEventVideoEventChangedEvent ();
    private static native String nativeStaticGetKeyPowerupMediaRecordEventVideoEventChangedError ();
    private static native String nativeStaticGetKeyPowerupNetworkSettingsStateWifiSelectionChangedType ();
    private static native String nativeStaticGetKeyPowerupNetworkSettingsStateWifiSelectionChangedBand ();
    private static native String nativeStaticGetKeyPowerupNetworkSettingsStateWifiSelectionChangedChannel ();
    private static native String nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedSsid ();
    private static native String nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedRssi ();
    private static native String nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedBand ();
    private static native String nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedChannel ();
    private static native String nativeStaticGetKeyPowerupNetworkStateWifiAuthChannelListChangedBand ();
    private static native String nativeStaticGetKeyPowerupNetworkStateWifiAuthChannelListChangedChannel ();
    private static native String nativeStaticGetKeyPowerupNetworkStateWifiAuthChannelListChangedInorout ();
    private static native String nativeStaticGetKeyPowerupNetworkStateLinkQualityChangedQuality ();
    private static native String nativeStaticGetKeyPowerupMediaStreamingStateVideoEnableChangedEnabled ();
    private static native String nativeStaticGetKeyPowerupVideoSettingsStateAutorecordChangedEnabled ();
    private static native String nativeStaticGetKeyPowerupVideoSettingsStateVideoModeChangedMode ();
    private static native String nativeStaticGetKeyPowerupSoundsStateBuzzChangedEnabled ();

    private native int nativeSendPilotingPCMD (long jFeature, byte flag, byte throttle, byte roll);
    private native int nativeSetPilotingPCMD (long jFeature, byte flag, byte throttle, byte roll);
    private native int nativeSetPilotingPCMDFlag (long jFeature, byte flag);
    private native int nativeSetPilotingPCMDThrottle (long jFeature, byte throttle);
    private native int nativeSetPilotingPCMDRoll (long jFeature, byte roll);
    private native int nativeSendPilotingUserTakeOff (long jFeature, byte state);
    private native int nativeSendPilotingMotorMode (long jFeature, int mode);
    private native int nativeSendPilotingSettingsSet (long jFeature, int setting, float value);
    private native int nativeSendMediaRecordPictureV2 (long jFeature);
    private native int nativeSendMediaRecordVideoV2 (long jFeature, int record);
    private native int nativeSendNetworkSettingsWifiSelection (long jFeature, int type, int band, byte channel);
    private native int nativeSendNetworkWifiScan (long jFeature, int band);
    private native int nativeSendNetworkWifiAuthChannel (long jFeature);
    private native int nativeSendMediaStreamingVideoEnable (long jFeature, byte enable);
    private native int nativeSendVideoSettingsAutorecord (long jFeature, byte enable);
    private native int nativeSendVideoSettingsVideoMode (long jFeature, int mode);
    private native int nativeSendSoundsBuzz (long jFeature, byte enable);

    private long jniFeature;
    private boolean initOk;
    
    static
    {
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ALERTSTATECHANGED_STATE = nativeStaticGetKeyPowerupPilotingStateAlertStateChangedState ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_FLYINGSTATECHANGED_STATE = nativeStaticGetKeyPowerupPilotingStateFlyingStateChangedState ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_MOTORMODECHANGED_MODE = nativeStaticGetKeyPowerupPilotingStateMotorModeChangedMode ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ATTITUDECHANGED_ROLL = nativeStaticGetKeyPowerupPilotingStateAttitudeChangedRoll ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ATTITUDECHANGED_PITCH = nativeStaticGetKeyPowerupPilotingStateAttitudeChangedPitch ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ATTITUDECHANGED_YAW = nativeStaticGetKeyPowerupPilotingStateAttitudeChangedYaw ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSTATE_ALTITUDECHANGED_ALTITUDE = nativeStaticGetKeyPowerupPilotingStateAltitudeChangedAltitude ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_SETTING = nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedSetting ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_CURRENT = nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedCurrent ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_MIN = nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedMin ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_PILOTINGSETTINGSSTATE_SETTINGCHANGED_MAX = nativeStaticGetKeyPowerupPilotingSettingsStateSettingChangedMax ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_PICTURESTATECHANGEDV2_STATE = nativeStaticGetKeyPowerupMediaRecordStatePictureStateChangedV2State ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_PICTURESTATECHANGEDV2_ERROR = nativeStaticGetKeyPowerupMediaRecordStatePictureStateChangedV2Error ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_VIDEOSTATECHANGEDV2_STATE = nativeStaticGetKeyPowerupMediaRecordStateVideoStateChangedV2State ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDSTATE_VIDEOSTATECHANGEDV2_ERROR = nativeStaticGetKeyPowerupMediaRecordStateVideoStateChangedV2Error ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_PICTUREEVENTCHANGED_EVENT = nativeStaticGetKeyPowerupMediaRecordEventPictureEventChangedEvent ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_PICTUREEVENTCHANGED_ERROR = nativeStaticGetKeyPowerupMediaRecordEventPictureEventChangedError ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_VIDEOEVENTCHANGED_EVENT = nativeStaticGetKeyPowerupMediaRecordEventVideoEventChangedEvent ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIARECORDEVENT_VIDEOEVENTCHANGED_ERROR = nativeStaticGetKeyPowerupMediaRecordEventVideoEventChangedError ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED_TYPE = nativeStaticGetKeyPowerupNetworkSettingsStateWifiSelectionChangedType ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED_BAND = nativeStaticGetKeyPowerupNetworkSettingsStateWifiSelectionChangedBand ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED_CHANNEL = nativeStaticGetKeyPowerupNetworkSettingsStateWifiSelectionChangedChannel ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_SSID = nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedSsid ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_RSSI = nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedRssi ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_BAND = nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedBand ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFISCANLISTCHANGED_CHANNEL = nativeStaticGetKeyPowerupNetworkStateWifiScanListChangedChannel ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED_BAND = nativeStaticGetKeyPowerupNetworkStateWifiAuthChannelListChangedBand ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED_CHANNEL = nativeStaticGetKeyPowerupNetworkStateWifiAuthChannelListChangedChannel ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED_IN_OR_OUT = nativeStaticGetKeyPowerupNetworkStateWifiAuthChannelListChangedInorout ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_NETWORKSTATE_LINKQUALITYCHANGED_QUALITY = nativeStaticGetKeyPowerupNetworkStateLinkQualityChangedQuality ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_MEDIASTREAMINGSTATE_VIDEOENABLECHANGED_ENABLED = nativeStaticGetKeyPowerupMediaStreamingStateVideoEnableChangedEnabled ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_VIDEOSETTINGSSTATE_AUTORECORDCHANGED_ENABLED = nativeStaticGetKeyPowerupVideoSettingsStateAutorecordChangedEnabled ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_VIDEOSETTINGSSTATE_VIDEOMODECHANGED_MODE = nativeStaticGetKeyPowerupVideoSettingsStateVideoModeChangedMode ();
        ARCONTROLLER_DICTIONARY_KEY_POWERUP_SOUNDSSTATE_BUZZCHANGED_ENABLED = nativeStaticGetKeyPowerupSoundsStateBuzzChangedEnabled ();
    }
    
    /**
     * Constructor
     */
    public ARFeaturePowerup (long nativeFeature)
    {
        initOk = false;
        
        if (nativeFeature != 0)
        {
            jniFeature = nativeFeature;
            initOk = true;
        }
    }

    /**
     * Dispose
     */
    public void dispose()
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                jniFeature = 0;
                initOk = false;
            }
        }
    }

    /**
     * Destructor
     */
    public void finalize () throws Throwable
    {
        try
        {
            dispose ();
        }
        finally
        {
            super.finalize ();
        }
    }
    
    /**
     * Send a command <code>PilotingPCMD</code>
     * Ask the Power Up speed and turn ratio.
     * @param flag Boolean for "touch screen".
     * @param throttle Throttle value [0:100].
     * @param roll Yaw-roll value. [-100:100]
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendPilotingPCMD (byte _flag, byte _throttle, byte _roll)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendPilotingPCMD (jniFeature, _flag, _throttle, _roll);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    public ARCONTROLLER_ERROR_ENUM setPilotingPCMD (byte _flag, byte _throttle, byte _roll)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSetPilotingPCMD (jniFeature, _flag, _throttle, _roll);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    public ARCONTROLLER_ERROR_ENUM setPilotingPCMDFlag (byte _flag)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSetPilotingPCMDFlag (jniFeature, _flag);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    public ARCONTROLLER_ERROR_ENUM setPilotingPCMDThrottle (byte _throttle)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSetPilotingPCMDThrottle (jniFeature, _throttle);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    public ARCONTROLLER_ERROR_ENUM setPilotingPCMDRoll (byte _roll)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSetPilotingPCMDRoll (jniFeature, _roll);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>PilotingUserTakeOff</code>
     * Set drone in user take off state
     * @param state State of user take off mode - 1 to enter in user take off. - 0 to exit from user take off.
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendPilotingUserTakeOff (byte _state)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendPilotingUserTakeOff (jniFeature, _state);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>PilotingMotorMode</code>
     * Motor mode
     * @param mode 
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendPilotingMotorMode (ARCOMMANDS_POWERUP_PILOTING_MOTORMODE_MODE_ENUM _mode)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendPilotingMotorMode (jniFeature, _mode.getValue());
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>PilotingSettingsSet</code>
     * Set the given setting
     * @param setting Variety of setting that can be customized
     * @param value value of the given setting
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendPilotingSettingsSet (ARCOMMANDS_POWERUP_PILOTINGSETTINGS_SET_SETTING_ENUM _setting, float _value)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendPilotingSettingsSet (jniFeature, _setting.getValue(), _value);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>MediaRecordPictureV2</code>
     * Take picture
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendMediaRecordPictureV2 ()
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendMediaRecordPictureV2 (jniFeature);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>MediaRecordVideoV2</code>
     * Video record
     * @param record Command to record video
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendMediaRecordVideoV2 (ARCOMMANDS_POWERUP_MEDIARECORD_VIDEOV2_RECORD_ENUM _record)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendMediaRecordVideoV2 (jniFeature, _record.getValue());
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>NetworkSettingsWifiSelection</code>
     * Auto-select channel of choosen band
     * @param type The type of wifi selection (auto, manual)
     * @param band The allowed band(s) : 2.4 Ghz, 5 Ghz, or all
     * @param channel The channel (not used in auto mode)
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendNetworkSettingsWifiSelection (ARCOMMANDS_POWERUP_NETWORKSETTINGS_WIFISELECTION_TYPE_ENUM _type, ARCOMMANDS_POWERUP_NETWORKSETTINGS_WIFISELECTION_BAND_ENUM _band, byte _channel)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendNetworkSettingsWifiSelection (jniFeature, _type.getValue(), _band.getValue(), _channel);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>NetworkWifiScan</code>
     * Launches wifi network scan
     * @param band The band(s) : 2.4 Ghz, 5 Ghz, or both
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendNetworkWifiScan (ARCOMMANDS_POWERUP_NETWORK_WIFISCAN_BAND_ENUM _band)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendNetworkWifiScan (jniFeature, _band.getValue());
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>NetworkWifiAuthChannel</code>
     * Controller inquire the list of authorized wifi channels.
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendNetworkWifiAuthChannel ()
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendNetworkWifiAuthChannel (jniFeature);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>MediaStreamingVideoEnable</code>
     * Enable/disable video streaming.
     * @param enable 1 to enable, 0 to disable.
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendMediaStreamingVideoEnable (byte _enable)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendMediaStreamingVideoEnable (jniFeature, _enable);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>VideoSettingsAutorecord</code>
     * Set video automatic recording state.
     * @param enable 0: Disabled 1: Enabled.
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendVideoSettingsAutorecord (byte _enable)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendVideoSettingsAutorecord (jniFeature, _enable);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>VideoSettingsVideoMode</code>
     * Set video mode
     * @param mode Video mode
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendVideoSettingsVideoMode (ARCOMMANDS_POWERUP_VIDEOSETTINGS_VIDEOMODE_MODE_ENUM _mode)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendVideoSettingsVideoMode (jniFeature, _mode.getValue());
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    
    /**
     * Send a command <code>SoundsBuzz</code>
     * Enable/disable the buzzer sound
     * @param enable 0: Disabled 1: Enabled.
     * return executing error
     */
    public ARCONTROLLER_ERROR_ENUM sendSoundsBuzz (byte _enable)
    {
        ARCONTROLLER_ERROR_ENUM error = ARCONTROLLER_ERROR_ENUM.ARCONTROLLER_OK;
        synchronized (this)
        {
            if(initOk == true)
            {
                int nativeError = nativeSendSoundsBuzz (jniFeature, _enable);
                error = ARCONTROLLER_ERROR_ENUM.getFromValue(nativeError);
            }
        }
        return error;
    }
    

}

