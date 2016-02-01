/*
    Copyright (C) 2014 Parrot SA

    Redistribution and use in source and binary forms, with or without
    modification, are permitted provided that the following conditions
    are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in
      the documentation and/or other materials provided with the 
      distribution.
    * Neither the name of Parrot nor the names
      of its contributors may be used to endorse or promote products
      derived from this software without specific prior written
      permission.

    THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
    "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
    LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS
    FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
    COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
    INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING,
    BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS
    OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED 
    AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
    OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
    OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
    SUCH DAMAGE.
*/
/*
 * GENERATED FILE
 *  Do not modify this file, it will be erased during the next configure run 
 */

package com.parrot.arsdk.arcontroller;

import java.util.HashMap;

/**
 * Java copy of the eARCONTROLLER_DICTIONARY_KEY enum
 */
public enum ARCONTROLLER_DICTIONARY_KEY_ENUM {
   /** Dummy value for all unknown cases */
    eARCONTROLLER_DICTIONARY_KEY_UNKNOWN_ENUM_VALUE (Integer.MIN_VALUE, "Dummy value for all unknown cases"),
   /** Key used to define the feature <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3 (0, "Key used to define the feature <code>ARDrone3</code>"),
   /** Key used to define the command <code>PictureStateChanged</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_MEDIARECORDSTATE_PICTURESTATECHANGED (1, "Key used to define the command <code>PictureStateChanged</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>VideoStateChanged</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_MEDIARECORDSTATE_VIDEOSTATECHANGED (2, "Key used to define the command <code>VideoStateChanged</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>PictureStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_MEDIARECORDSTATE_PICTURESTATECHANGEDV2 (3, "Key used to define the command <code>PictureStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>VideoStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_MEDIARECORDSTATE_VIDEOSTATECHANGEDV2 (4, "Key used to define the command <code>VideoStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>PictureEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_MEDIARECORDEVENT_PICTUREEVENTCHANGED (5, "Key used to define the command <code>PictureEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>VideoEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_MEDIARECORDEVENT_VIDEOEVENTCHANGED (6, "Key used to define the command <code>VideoEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>FlatTrimChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_FLATTRIMCHANGED (7, "Key used to define the command <code>FlatTrimChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>FlyingStateChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_FLYINGSTATECHANGED (8, "Key used to define the command <code>FlyingStateChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AlertStateChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_ALERTSTATECHANGED (9, "Key used to define the command <code>AlertStateChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>NavigateHomeStateChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_NAVIGATEHOMESTATECHANGED (10, "Key used to define the command <code>NavigateHomeStateChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>PositionChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_POSITIONCHANGED (11, "Key used to define the command <code>PositionChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>SpeedChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_SPEEDCHANGED (12, "Key used to define the command <code>SpeedChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AttitudeChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_ATTITUDECHANGED (13, "Key used to define the command <code>AttitudeChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AutoTakeOffModeChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_AUTOTAKEOFFMODECHANGED (14, "Key used to define the command <code>AutoTakeOffModeChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AltitudeChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSTATE_ALTITUDECHANGED (15, "Key used to define the command <code>AltitudeChanged</code> of class <code>PilotingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MoveByEnd</code> of class <code>PilotingEvent</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGEVENT_MOVEBYEND (16, "Key used to define the command <code>MoveByEnd</code> of class <code>PilotingEvent</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>WifiScanListChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_NETWORKSTATE_WIFISCANLISTCHANGED (17, "Key used to define the command <code>WifiScanListChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AllWifiScanChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_NETWORKSTATE_ALLWIFISCANCHANGED (18, "Key used to define the command <code>AllWifiScanChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>WifiAuthChannelListChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED (19, "Key used to define the command <code>WifiAuthChannelListChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AllWifiAuthChannelChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_NETWORKSTATE_ALLWIFIAUTHCHANNELCHANGED (20, "Key used to define the command <code>AllWifiAuthChannelChanged</code> of class <code>NetworkState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MaxAltitudeChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_MAXALTITUDECHANGED (21, "Key used to define the command <code>MaxAltitudeChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MaxTiltChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_MAXTILTCHANGED (22, "Key used to define the command <code>MaxTiltChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AbsolutControlChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_ABSOLUTCONTROLCHANGED (23, "Key used to define the command <code>AbsolutControlChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MaxDistanceChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_MAXDISTANCECHANGED (24, "Key used to define the command <code>MaxDistanceChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>NoFlyOverMaxDistanceChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_NOFLYOVERMAXDISTANCECHANGED (25, "Key used to define the command <code>NoFlyOverMaxDistanceChanged</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AutonomousFlightMaxHorizontalSpeed</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_AUTONOMOUSFLIGHTMAXHORIZONTALSPEED (26, "Key used to define the command <code>AutonomousFlightMaxHorizontalSpeed</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AutonomousFlightMaxVerticalSpeed</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_AUTONOMOUSFLIGHTMAXVERTICALSPEED (27, "Key used to define the command <code>AutonomousFlightMaxVerticalSpeed</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AutonomousFlightMaxHorizontalAcceleration</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_AUTONOMOUSFLIGHTMAXHORIZONTALACCELERATION (28, "Key used to define the command <code>AutonomousFlightMaxHorizontalAcceleration</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AutonomousFlightMaxVerticalAcceleration</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_AUTONOMOUSFLIGHTMAXVERTICALACCELERATION (29, "Key used to define the command <code>AutonomousFlightMaxVerticalAcceleration</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AutonomousFlightMaxRotationSpeed</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PILOTINGSETTINGSSTATE_AUTONOMOUSFLIGHTMAXROTATIONSPEED (30, "Key used to define the command <code>AutonomousFlightMaxRotationSpeed</code> of class <code>PilotingSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MaxVerticalSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SPEEDSETTINGSSTATE_MAXVERTICALSPEEDCHANGED (31, "Key used to define the command <code>MaxVerticalSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MaxRotationSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SPEEDSETTINGSSTATE_MAXROTATIONSPEEDCHANGED (32, "Key used to define the command <code>MaxRotationSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>HullProtectionChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SPEEDSETTINGSSTATE_HULLPROTECTIONCHANGED (33, "Key used to define the command <code>HullProtectionChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>OutdoorChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SPEEDSETTINGSSTATE_OUTDOORCHANGED (34, "Key used to define the command <code>OutdoorChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MaxPitchRollRotationSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SPEEDSETTINGSSTATE_MAXPITCHROLLROTATIONSPEEDCHANGED (35, "Key used to define the command <code>MaxPitchRollRotationSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>WifiSelectionChanged</code> of class <code>NetworkSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED (36, "Key used to define the command <code>WifiSelectionChanged</code> of class <code>NetworkSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>WifiSecurityChanged</code> of class <code>NetworkSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_NETWORKSETTINGSSTATE_WIFISECURITYCHANGED (37, "Key used to define the command <code>WifiSecurityChanged</code> of class <code>NetworkSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>WifiSecurity</code> of class <code>NetworkSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_NETWORKSETTINGSSTATE_WIFISECURITY (38, "Key used to define the command <code>WifiSecurity</code> of class <code>NetworkSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>ProductMotorVersionListChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SETTINGSSTATE_PRODUCTMOTORVERSIONLISTCHANGED (39, "Key used to define the command <code>ProductMotorVersionListChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>ProductGPSVersionChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SETTINGSSTATE_PRODUCTGPSVERSIONCHANGED (40, "Key used to define the command <code>ProductGPSVersionChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MotorErrorStateChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SETTINGSSTATE_MOTORERRORSTATECHANGED (41, "Key used to define the command <code>MotorErrorStateChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MotorSoftwareVersionChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SETTINGSSTATE_MOTORSOFTWAREVERSIONCHANGED (42, "Key used to define the command <code>MotorSoftwareVersionChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MotorFlightsStatusChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SETTINGSSTATE_MOTORFLIGHTSSTATUSCHANGED (43, "Key used to define the command <code>MotorFlightsStatusChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>MotorErrorLastErrorChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SETTINGSSTATE_MOTORERRORLASTERRORCHANGED (44, "Key used to define the command <code>MotorErrorLastErrorChanged</code> of class <code>SettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>P7ID</code> of class <code>SettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_SETTINGSSTATE_P7ID (45, "Key used to define the command <code>P7ID</code> of class <code>SettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>PictureFormatChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PICTURESETTINGSSTATE_PICTUREFORMATCHANGED (46, "Key used to define the command <code>PictureFormatChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>AutoWhiteBalanceChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PICTURESETTINGSSTATE_AUTOWHITEBALANCECHANGED (47, "Key used to define the command <code>AutoWhiteBalanceChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>ExpositionChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PICTURESETTINGSSTATE_EXPOSITIONCHANGED (48, "Key used to define the command <code>ExpositionChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>SaturationChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PICTURESETTINGSSTATE_SATURATIONCHANGED (49, "Key used to define the command <code>SaturationChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>TimelapseChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PICTURESETTINGSSTATE_TIMELAPSECHANGED (50, "Key used to define the command <code>TimelapseChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>VideoAutorecordChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PICTURESETTINGSSTATE_VIDEOAUTORECORDCHANGED (51, "Key used to define the command <code>VideoAutorecordChanged</code> of class <code>PictureSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>VideoEnableChanged</code> of class <code>MediaStreamingState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_MEDIASTREAMINGSTATE_VIDEOENABLECHANGED (52, "Key used to define the command <code>VideoEnableChanged</code> of class <code>MediaStreamingState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>HomeChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSETTINGSSTATE_HOMECHANGED (53, "Key used to define the command <code>HomeChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>ResetHomeChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSETTINGSSTATE_RESETHOMECHANGED (54, "Key used to define the command <code>ResetHomeChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>GPSFixStateChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSETTINGSSTATE_GPSFIXSTATECHANGED (55, "Key used to define the command <code>GPSFixStateChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>GPSUpdateStateChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSETTINGSSTATE_GPSUPDATESTATECHANGED (56, "Key used to define the command <code>GPSUpdateStateChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>HomeTypeChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSETTINGSSTATE_HOMETYPECHANGED (57, "Key used to define the command <code>HomeTypeChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>ReturnHomeDelayChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSETTINGSSTATE_RETURNHOMEDELAYCHANGED (58, "Key used to define the command <code>ReturnHomeDelayChanged</code> of class <code>GPSSettingsState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>Orientation</code> of class <code>CameraState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_ORIENTATION (59, "Key used to define the command <code>Orientation</code> of class <code>CameraState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>DefaultCameraOrientation</code> of class <code>CameraState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_DEFAULTCAMERAORIENTATION (60, "Key used to define the command <code>DefaultCameraOrientation</code> of class <code>CameraState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>ElectricFrequencyChanged</code> of class <code>AntiflickeringState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_ANTIFLICKERINGSTATE_ELECTRICFREQUENCYCHANGED (61, "Key used to define the command <code>ElectricFrequencyChanged</code> of class <code>AntiflickeringState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>ModeChanged</code> of class <code>AntiflickeringState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_ANTIFLICKERINGSTATE_MODECHANGED (62, "Key used to define the command <code>ModeChanged</code> of class <code>AntiflickeringState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>NumberOfSatelliteChanged</code> of class <code>GPSState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSTATE_NUMBEROFSATELLITECHANGED (63, "Key used to define the command <code>NumberOfSatelliteChanged</code> of class <code>GPSState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>HomeTypeAvailabilityChanged</code> of class <code>GPSState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSTATE_HOMETYPEAVAILABILITYCHANGED (64, "Key used to define the command <code>HomeTypeAvailabilityChanged</code> of class <code>GPSState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>HomeTypeChosenChanged</code> of class <code>GPSState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_GPSSTATE_HOMETYPECHOSENCHANGED (65, "Key used to define the command <code>HomeTypeChosenChanged</code> of class <code>GPSState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the command <code>Features</code> of class <code>PROState</code> in project <code>ARDrone3</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_PROSTATE_FEATURES (66, "Key used to define the command <code>Features</code> of class <code>PROState</code> in project <code>ARDrone3</code>"),
   /** Key used to define the feature <code>ARDrone3Debug</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3DEBUG (67, "Key used to define the feature <code>ARDrone3Debug</code>"),
   /** Key used to define the command <code>UseDrone2BatteryChanged</code> of class <code>BatteryDebugSettingsState</code> in project <code>ARDrone3Debug</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3DEBUG_BATTERYDEBUGSETTINGSSTATE_USEDRONE2BATTERYCHANGED (68, "Key used to define the command <code>UseDrone2BatteryChanged</code> of class <code>BatteryDebugSettingsState</code> in project <code>ARDrone3Debug</code>"),
   /** Key used to define the command <code>NbSatelliteChanged</code> of class <code>GPSDebugState</code> in project <code>ARDrone3Debug</code> */
    ARCONTROLLER_DICTIONARY_KEY_ARDRONE3DEBUG_GPSDEBUGSTATE_NBSATELLITECHANGED (69, "Key used to define the command <code>NbSatelliteChanged</code> of class <code>GPSDebugState</code> in project <code>ARDrone3Debug</code>"),
   /** Key used to define the feature <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO (70, "Key used to define the feature <code>JumpingSumo</code>"),
   /** Key used to define the command <code>PostureChanged</code> of class <code>PilotingState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_PILOTINGSTATE_POSTURECHANGED (71, "Key used to define the command <code>PostureChanged</code> of class <code>PilotingState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>AlertStateChanged</code> of class <code>PilotingState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_PILOTINGSTATE_ALERTSTATECHANGED (72, "Key used to define the command <code>AlertStateChanged</code> of class <code>PilotingState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>SpeedChanged</code> of class <code>PilotingState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_PILOTINGSTATE_SPEEDCHANGED (73, "Key used to define the command <code>SpeedChanged</code> of class <code>PilotingState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>JumpLoadChanged</code> of class <code>AnimationsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ANIMATIONSSTATE_JUMPLOADCHANGED (74, "Key used to define the command <code>JumpLoadChanged</code> of class <code>AnimationsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>JumpTypeChanged</code> of class <code>AnimationsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ANIMATIONSSTATE_JUMPTYPECHANGED (75, "Key used to define the command <code>JumpTypeChanged</code> of class <code>AnimationsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>JumpMotorProblemChanged</code> of class <code>AnimationsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ANIMATIONSSTATE_JUMPMOTORPROBLEMCHANGED (76, "Key used to define the command <code>JumpMotorProblemChanged</code> of class <code>AnimationsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>ProductGPSVersionChanged</code> of class <code>SettingsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_SETTINGSSTATE_PRODUCTGPSVERSIONCHANGED (77, "Key used to define the command <code>ProductGPSVersionChanged</code> of class <code>SettingsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>PictureStateChanged</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_MEDIARECORDSTATE_PICTURESTATECHANGED (78, "Key used to define the command <code>PictureStateChanged</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>VideoStateChanged</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_MEDIARECORDSTATE_VIDEOSTATECHANGED (79, "Key used to define the command <code>VideoStateChanged</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>PictureStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_MEDIARECORDSTATE_PICTURESTATECHANGEDV2 (80, "Key used to define the command <code>PictureStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>VideoStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_MEDIARECORDSTATE_VIDEOSTATECHANGEDV2 (81, "Key used to define the command <code>VideoStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>PictureEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_MEDIARECORDEVENT_PICTUREEVENTCHANGED (82, "Key used to define the command <code>PictureEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>VideoEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_MEDIARECORDEVENT_VIDEOEVENTCHANGED (83, "Key used to define the command <code>VideoEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>WifiSelectionChanged</code> of class <code>NetworkSettingsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_NETWORKSETTINGSSTATE_WIFISELECTIONCHANGED (84, "Key used to define the command <code>WifiSelectionChanged</code> of class <code>NetworkSettingsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>WifiScanListChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_NETWORKSTATE_WIFISCANLISTCHANGED (85, "Key used to define the command <code>WifiScanListChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>AllWifiScanChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_NETWORKSTATE_ALLWIFISCANCHANGED (86, "Key used to define the command <code>AllWifiScanChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>WifiAuthChannelListChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_NETWORKSTATE_WIFIAUTHCHANNELLISTCHANGED (87, "Key used to define the command <code>WifiAuthChannelListChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>AllWifiAuthChannelChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_NETWORKSTATE_ALLWIFIAUTHCHANNELCHANGED (88, "Key used to define the command <code>AllWifiAuthChannelChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>LinkQualityChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_NETWORKSTATE_LINKQUALITYCHANGED (89, "Key used to define the command <code>LinkQualityChanged</code> of class <code>NetworkState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>MasterVolumeChanged</code> of class <code>AudioSettingsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_AUDIOSETTINGSSTATE_MASTERVOLUMECHANGED (90, "Key used to define the command <code>MasterVolumeChanged</code> of class <code>AudioSettingsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>ThemeChanged</code> of class <code>AudioSettingsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_AUDIOSETTINGSSTATE_THEMECHANGED (91, "Key used to define the command <code>ThemeChanged</code> of class <code>AudioSettingsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>ScriptMetadataListChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ROADPLANSTATE_SCRIPTMETADATALISTCHANGED (92, "Key used to define the command <code>ScriptMetadataListChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>AllScriptsMetadataChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ROADPLANSTATE_ALLSCRIPTSMETADATACHANGED (93, "Key used to define the command <code>AllScriptsMetadataChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>ScriptUploadChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ROADPLANSTATE_SCRIPTUPLOADCHANGED (94, "Key used to define the command <code>ScriptUploadChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>ScriptDeleteChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ROADPLANSTATE_SCRIPTDELETECHANGED (95, "Key used to define the command <code>ScriptDeleteChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>PlayScriptChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_ROADPLANSTATE_PLAYSCRIPTCHANGED (96, "Key used to define the command <code>PlayScriptChanged</code> of class <code>RoadPlanState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>OutdoorChanged</code> of class <code>SpeedSettingsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_SPEEDSETTINGSSTATE_OUTDOORCHANGED (97, "Key used to define the command <code>OutdoorChanged</code> of class <code>SpeedSettingsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>VideoEnableChanged</code> of class <code>MediaStreamingState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_MEDIASTREAMINGSTATE_VIDEOENABLECHANGED (98, "Key used to define the command <code>VideoEnableChanged</code> of class <code>MediaStreamingState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the command <code>AutorecordChanged</code> of class <code>VideoSettingsState</code> in project <code>JumpingSumo</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMO_VIDEOSETTINGSSTATE_AUTORECORDCHANGED (99, "Key used to define the command <code>AutorecordChanged</code> of class <code>VideoSettingsState</code> in project <code>JumpingSumo</code>"),
   /** Key used to define the feature <code>JumpingSumoDebug</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMODEBUG (100, "Key used to define the feature <code>JumpingSumoDebug</code>"),
   /** Key used to define the command <code>UserScriptParsed</code> of class <code>UserScriptState</code> in project <code>JumpingSumoDebug</code> */
    ARCONTROLLER_DICTIONARY_KEY_JUMPINGSUMODEBUG_USERSCRIPTSTATE_USERSCRIPTPARSED (101, "Key used to define the command <code>UserScriptParsed</code> of class <code>UserScriptState</code> in project <code>JumpingSumoDebug</code>"),
   /** Key used to define the feature <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE (102, "Key used to define the feature <code>MiniDrone</code>"),
   /** Key used to define the command <code>FlatTrimChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_PILOTINGSTATE_FLATTRIMCHANGED (103, "Key used to define the command <code>FlatTrimChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>FlyingStateChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_PILOTINGSTATE_FLYINGSTATECHANGED (104, "Key used to define the command <code>FlyingStateChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>AlertStateChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_PILOTINGSTATE_ALERTSTATECHANGED (105, "Key used to define the command <code>AlertStateChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>AutoTakeOffModeChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_PILOTINGSTATE_AUTOTAKEOFFMODECHANGED (106, "Key used to define the command <code>AutoTakeOffModeChanged</code> of class <code>PilotingState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>PictureStateChanged</code> of class <code>MediaRecordState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_MEDIARECORDSTATE_PICTURESTATECHANGED (107, "Key used to define the command <code>PictureStateChanged</code> of class <code>MediaRecordState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>PictureStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_MEDIARECORDSTATE_PICTURESTATECHANGEDV2 (108, "Key used to define the command <code>PictureStateChangedV2</code> of class <code>MediaRecordState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>PictureEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_MEDIARECORDEVENT_PICTUREEVENTCHANGED (109, "Key used to define the command <code>PictureEventChanged</code> of class <code>MediaRecordEvent</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>MaxAltitudeChanged</code> of class <code>PilotingSettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_PILOTINGSETTINGSSTATE_MAXALTITUDECHANGED (110, "Key used to define the command <code>MaxAltitudeChanged</code> of class <code>PilotingSettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>MaxTiltChanged</code> of class <code>PilotingSettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_PILOTINGSETTINGSSTATE_MAXTILTCHANGED (111, "Key used to define the command <code>MaxTiltChanged</code> of class <code>PilotingSettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>MaxVerticalSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_SPEEDSETTINGSSTATE_MAXVERTICALSPEEDCHANGED (112, "Key used to define the command <code>MaxVerticalSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>MaxRotationSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_SPEEDSETTINGSSTATE_MAXROTATIONSPEEDCHANGED (113, "Key used to define the command <code>MaxRotationSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>WheelsChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_SPEEDSETTINGSSTATE_WHEELSCHANGED (114, "Key used to define the command <code>WheelsChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>MaxHorizontalSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_SPEEDSETTINGSSTATE_MAXHORIZONTALSPEEDCHANGED (115, "Key used to define the command <code>MaxHorizontalSpeedChanged</code> of class <code>SpeedSettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>ProductMotorsVersionChanged</code> of class <code>SettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_SETTINGSSTATE_PRODUCTMOTORSVERSIONCHANGED (116, "Key used to define the command <code>ProductMotorsVersionChanged</code> of class <code>SettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>ProductInertialVersionChanged</code> of class <code>SettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_SETTINGSSTATE_PRODUCTINERTIALVERSIONCHANGED (117, "Key used to define the command <code>ProductInertialVersionChanged</code> of class <code>SettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>CutOutModeChanged</code> of class <code>SettingsState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_SETTINGSSTATE_CUTOUTMODECHANGED (118, "Key used to define the command <code>CutOutModeChanged</code> of class <code>SettingsState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the command <code>FloodControlChanged</code> of class <code>FloodControlState</code> in project <code>MiniDrone</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONE_FLOODCONTROLSTATE_FLOODCONTROLCHANGED (119, "Key used to define the command <code>FloodControlChanged</code> of class <code>FloodControlState</code> in project <code>MiniDrone</code>"),
   /** Key used to define the feature <code>MiniDroneDebug</code> */
    ARCONTROLLER_DICTIONARY_KEY_MINIDRONEDEBUG (120, "Key used to define the feature <code>MiniDroneDebug</code>"),
   /** Key used to define the feature <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER (121, "Key used to define the feature <code>SkyController</code>"),
   /** Key used to define the command <code>WifiList</code> of class <code>WifiState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_WIFISTATE_WIFILIST (122, "Key used to define the command <code>WifiList</code> of class <code>WifiState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>ConnexionChanged</code> of class <code>WifiState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_WIFISTATE_CONNEXIONCHANGED (123, "Key used to define the command <code>ConnexionChanged</code> of class <code>WifiState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>WifiAuthChannelListChanged</code> of class <code>WifiState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_WIFISTATE_WIFIAUTHCHANNELLISTCHANGED (124, "Key used to define the command <code>WifiAuthChannelListChanged</code> of class <code>WifiState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllWifiAuthChannelChanged</code> of class <code>WifiState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_WIFISTATE_ALLWIFIAUTHCHANNELCHANGED (125, "Key used to define the command <code>AllWifiAuthChannelChanged</code> of class <code>WifiState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>WifiSignalChanged</code> of class <code>WifiState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_WIFISTATE_WIFISIGNALCHANGED (126, "Key used to define the command <code>WifiSignalChanged</code> of class <code>WifiState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>DeviceList</code> of class <code>DeviceState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_DEVICESTATE_DEVICELIST (127, "Key used to define the command <code>DeviceList</code> of class <code>DeviceState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>ConnexionChanged</code> of class <code>DeviceState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_DEVICESTATE_CONNEXIONCHANGED (128, "Key used to define the command <code>ConnexionChanged</code> of class <code>DeviceState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllSettingsChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_SETTINGSSTATE_ALLSETTINGSCHANGED (129, "Key used to define the command <code>AllSettingsChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>ResetChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_SETTINGSSTATE_RESETCHANGED (130, "Key used to define the command <code>ResetChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>ProductSerialChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_SETTINGSSTATE_PRODUCTSERIALCHANGED (131, "Key used to define the command <code>ProductSerialChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>ProductVariantChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_SETTINGSSTATE_PRODUCTVARIANTCHANGED (132, "Key used to define the command <code>ProductVariantChanged</code> of class <code>SettingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllStatesChanged</code> of class <code>CommonState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_COMMONSTATE_ALLSTATESCHANGED (133, "Key used to define the command <code>AllStatesChanged</code> of class <code>CommonState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>BatteryChanged</code> of class <code>SkyControllerState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_SKYCONTROLLERSTATE_BATTERYCHANGED (134, "Key used to define the command <code>BatteryChanged</code> of class <code>SkyControllerState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>GpsFixChanged</code> of class <code>SkyControllerState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_SKYCONTROLLERSTATE_GPSFIXCHANGED (135, "Key used to define the command <code>GpsFixChanged</code> of class <code>SkyControllerState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>GpsPositionChanged</code> of class <code>SkyControllerState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_SKYCONTROLLERSTATE_GPSPOSITIONCHANGED (136, "Key used to define the command <code>GpsPositionChanged</code> of class <code>SkyControllerState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AccessPointSSIDChanged</code> of class <code>AccessPointSettingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_ACCESSPOINTSETTINGSSTATE_ACCESSPOINTSSIDCHANGED (137, "Key used to define the command <code>AccessPointSSIDChanged</code> of class <code>AccessPointSettingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AccessPointChannelChanged</code> of class <code>AccessPointSettingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_ACCESSPOINTSETTINGSSTATE_ACCESSPOINTCHANNELCHANGED (138, "Key used to define the command <code>AccessPointChannelChanged</code> of class <code>AccessPointSettingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>WifiSelectionChanged</code> of class <code>AccessPointSettingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_ACCESSPOINTSETTINGSSTATE_WIFISELECTIONCHANGED (139, "Key used to define the command <code>WifiSelectionChanged</code> of class <code>AccessPointSettingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>GamepadControl</code> of class <code>GamepadInfosState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_GAMEPADINFOSSTATE_GAMEPADCONTROL (140, "Key used to define the command <code>GamepadControl</code> of class <code>GamepadInfosState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllGamepadControlsSent</code> of class <code>GamepadInfosState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_GAMEPADINFOSSTATE_ALLGAMEPADCONTROLSSENT (141, "Key used to define the command <code>AllGamepadControlsSent</code> of class <code>GamepadInfosState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>CurrentButtonMappings</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_BUTTONMAPPINGSSTATE_CURRENTBUTTONMAPPINGS (142, "Key used to define the command <code>CurrentButtonMappings</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllCurrentButtonMappingsSent</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_BUTTONMAPPINGSSTATE_ALLCURRENTBUTTONMAPPINGSSENT (143, "Key used to define the command <code>AllCurrentButtonMappingsSent</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AvailableButtonMappings</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_BUTTONMAPPINGSSTATE_AVAILABLEBUTTONMAPPINGS (144, "Key used to define the command <code>AvailableButtonMappings</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllAvailableButtonsMappingsSent</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_BUTTONMAPPINGSSTATE_ALLAVAILABLEBUTTONSMAPPINGSSENT (145, "Key used to define the command <code>AllAvailableButtonsMappingsSent</code> of class <code>ButtonMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>CurrentAxisMappings</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISMAPPINGSSTATE_CURRENTAXISMAPPINGS (146, "Key used to define the command <code>CurrentAxisMappings</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllCurrentAxisMappingsSent</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISMAPPINGSSTATE_ALLCURRENTAXISMAPPINGSSENT (147, "Key used to define the command <code>AllCurrentAxisMappingsSent</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AvailableAxisMappings</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISMAPPINGSSTATE_AVAILABLEAXISMAPPINGS (148, "Key used to define the command <code>AvailableAxisMappings</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllAvailableAxisMappingsSent</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISMAPPINGSSTATE_ALLAVAILABLEAXISMAPPINGSSENT (149, "Key used to define the command <code>AllAvailableAxisMappingsSent</code> of class <code>AxisMappingsState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>CurrentAxisFilters</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISFILTERSSTATE_CURRENTAXISFILTERS (150, "Key used to define the command <code>CurrentAxisFilters</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllCurrentFiltersSent</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISFILTERSSTATE_ALLCURRENTFILTERSSENT (151, "Key used to define the command <code>AllCurrentFiltersSent</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>PresetAxisFilters</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISFILTERSSTATE_PRESETAXISFILTERS (152, "Key used to define the command <code>PresetAxisFilters</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>AllPresetFiltersSent</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_AXISFILTERSSTATE_ALLPRESETFILTERSSENT (153, "Key used to define the command <code>AllPresetFiltersSent</code> of class <code>AxisFiltersState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>PilotingSource</code> of class <code>CoPilotingState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_COPILOTINGSTATE_PILOTINGSOURCE (154, "Key used to define the command <code>PilotingSource</code> of class <code>CoPilotingState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>MagnetoCalibrationState</code> of class <code>CalibrationState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_CALIBRATIONSTATE_MAGNETOCALIBRATIONSTATE (155, "Key used to define the command <code>MagnetoCalibrationState</code> of class <code>CalibrationState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>MagnetoCalibrationQualityUpdatesState</code> of class <code>CalibrationState</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_CALIBRATIONSTATE_MAGNETOCALIBRATIONQUALITYUPDATESSTATE (156, "Key used to define the command <code>MagnetoCalibrationQualityUpdatesState</code> of class <code>CalibrationState</code> in project <code>SkyController</code>"),
   /** Key used to define the command <code>Settings</code> of class <code>ButtonEvents</code> in project <code>SkyController</code> */
    ARCONTROLLER_DICTIONARY_KEY_SKYCONTROLLER_BUTTONEVENTS_SETTINGS (157, "Key used to define the command <code>Settings</code> of class <code>ButtonEvents</code> in project <code>SkyController</code>"),
   /** Key used to define the feature <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON (158, "Key used to define the feature <code>Common</code>"),
   /** Key used to define the command <code>Disconnection</code> of class <code>NetworkEvent</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_NETWORKEVENT_DISCONNECTION (159, "Key used to define the command <code>Disconnection</code> of class <code>NetworkEvent</code> in project <code>Common</code>"),
   /** Key used to define the command <code>AllSettingsChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_ALLSETTINGSCHANGED (160, "Key used to define the command <code>AllSettingsChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ResetChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_RESETCHANGED (161, "Key used to define the command <code>ResetChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ProductNameChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_PRODUCTNAMECHANGED (162, "Key used to define the command <code>ProductNameChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ProductVersionChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_PRODUCTVERSIONCHANGED (163, "Key used to define the command <code>ProductVersionChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ProductSerialHighChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_PRODUCTSERIALHIGHCHANGED (164, "Key used to define the command <code>ProductSerialHighChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ProductSerialLowChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_PRODUCTSERIALLOWCHANGED (165, "Key used to define the command <code>ProductSerialLowChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>CountryChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_COUNTRYCHANGED (166, "Key used to define the command <code>CountryChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>AutoCountryChanged</code> of class <code>SettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_SETTINGSSTATE_AUTOCOUNTRYCHANGED (167, "Key used to define the command <code>AutoCountryChanged</code> of class <code>SettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>AllStatesChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_ALLSTATESCHANGED (168, "Key used to define the command <code>AllStatesChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>BatteryStateChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_BATTERYSTATECHANGED (169, "Key used to define the command <code>BatteryStateChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MassStorageStateListChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_MASSSTORAGESTATELISTCHANGED (170, "Key used to define the command <code>MassStorageStateListChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MassStorageInfoStateListChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_MASSSTORAGEINFOSTATELISTCHANGED (171, "Key used to define the command <code>MassStorageInfoStateListChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>CurrentDateChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_CURRENTDATECHANGED (172, "Key used to define the command <code>CurrentDateChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>CurrentTimeChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_CURRENTTIMECHANGED (173, "Key used to define the command <code>CurrentTimeChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MassStorageInfoRemainingListChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_MASSSTORAGEINFOREMAININGLISTCHANGED (174, "Key used to define the command <code>MassStorageInfoRemainingListChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>WifiSignalChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_WIFISIGNALCHANGED (175, "Key used to define the command <code>WifiSignalChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>SensorsStatesListChanged</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_SENSORSSTATESLISTCHANGED (176, "Key used to define the command <code>SensorsStatesListChanged</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ProductModel</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_PRODUCTMODEL (177, "Key used to define the command <code>ProductModel</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>CountryListKnown</code> of class <code>CommonState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_COMMONSTATE_COUNTRYLISTKNOWN (178, "Key used to define the command <code>CountryListKnown</code> of class <code>CommonState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>OverHeatChanged</code> of class <code>OverHeatState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_OVERHEATSTATE_OVERHEATCHANGED (179, "Key used to define the command <code>OverHeatChanged</code> of class <code>OverHeatState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>OverHeatRegulationChanged</code> of class <code>OverHeatState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_OVERHEATSTATE_OVERHEATREGULATIONCHANGED (180, "Key used to define the command <code>OverHeatRegulationChanged</code> of class <code>OverHeatState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>IsPilotingChanged</code> of class <code>ControllerState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CONTROLLERSTATE_ISPILOTINGCHANGED (181, "Key used to define the command <code>IsPilotingChanged</code> of class <code>ControllerState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>OutdoorSettingsChanged</code> of class <code>WifiSettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_WIFISETTINGSSTATE_OUTDOORSETTINGSCHANGED (182, "Key used to define the command <code>OutdoorSettingsChanged</code> of class <code>WifiSettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MavlinkFilePlayingStateChanged</code> of class <code>MavlinkState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_MAVLINKSTATE_MAVLINKFILEPLAYINGSTATECHANGED (183, "Key used to define the command <code>MavlinkFilePlayingStateChanged</code> of class <code>MavlinkState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MavlinkPlayErrorStateChanged</code> of class <code>MavlinkState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_MAVLINKSTATE_MAVLINKPLAYERRORSTATECHANGED (184, "Key used to define the command <code>MavlinkPlayErrorStateChanged</code> of class <code>MavlinkState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MagnetoCalibrationStateChanged</code> of class <code>CalibrationState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CALIBRATIONSTATE_MAGNETOCALIBRATIONSTATECHANGED (185, "Key used to define the command <code>MagnetoCalibrationStateChanged</code> of class <code>CalibrationState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MagnetoCalibrationRequiredState</code> of class <code>CalibrationState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CALIBRATIONSTATE_MAGNETOCALIBRATIONREQUIREDSTATE (186, "Key used to define the command <code>MagnetoCalibrationRequiredState</code> of class <code>CalibrationState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MagnetoCalibrationAxisToCalibrateChanged</code> of class <code>CalibrationState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CALIBRATIONSTATE_MAGNETOCALIBRATIONAXISTOCALIBRATECHANGED (187, "Key used to define the command <code>MagnetoCalibrationAxisToCalibrateChanged</code> of class <code>CalibrationState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MagnetoCalibrationStartedChanged</code> of class <code>CalibrationState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CALIBRATIONSTATE_MAGNETOCALIBRATIONSTARTEDCHANGED (188, "Key used to define the command <code>MagnetoCalibrationStartedChanged</code> of class <code>CalibrationState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>CameraSettingsChanged</code> of class <code>CameraSettingsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CAMERASETTINGSSTATE_CAMERASETTINGSCHANGED (189, "Key used to define the command <code>CameraSettingsChanged</code> of class <code>CameraSettingsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>AvailabilityStateChanged</code> of class <code>FlightPlanState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_FLIGHTPLANSTATE_AVAILABILITYSTATECHANGED (190, "Key used to define the command <code>AvailabilityStateChanged</code> of class <code>FlightPlanState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ComponentStateListChanged</code> of class <code>FlightPlanState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_FLIGHTPLANSTATE_COMPONENTSTATELISTCHANGED (191, "Key used to define the command <code>ComponentStateListChanged</code> of class <code>FlightPlanState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>StartingErrorEvent</code> of class <code>FlightPlanEvent</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_FLIGHTPLANEVENT_STARTINGERROREVENT (192, "Key used to define the command <code>StartingErrorEvent</code> of class <code>FlightPlanEvent</code> in project <code>Common</code>"),
   /** Key used to define the command <code>SpeedBridleEvent</code> of class <code>FlightPlanEvent</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_FLIGHTPLANEVENT_SPEEDBRIDLEEVENT (193, "Key used to define the command <code>SpeedBridleEvent</code> of class <code>FlightPlanEvent</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ControllerLibARCommandsVersion</code> of class <code>ARLibsVersionsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_ARLIBSVERSIONSSTATE_CONTROLLERLIBARCOMMANDSVERSION (194, "Key used to define the command <code>ControllerLibARCommandsVersion</code> of class <code>ARLibsVersionsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>SkyControllerLibARCommandsVersion</code> of class <code>ARLibsVersionsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_ARLIBSVERSIONSSTATE_SKYCONTROLLERLIBARCOMMANDSVERSION (195, "Key used to define the command <code>SkyControllerLibARCommandsVersion</code> of class <code>ARLibsVersionsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>DeviceLibARCommandsVersion</code> of class <code>ARLibsVersionsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_ARLIBSVERSIONSSTATE_DEVICELIBARCOMMANDSVERSION (196, "Key used to define the command <code>DeviceLibARCommandsVersion</code> of class <code>ARLibsVersionsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>AudioStreamingRunning</code> of class <code>AudioState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_AUDIOSTATE_AUDIOSTREAMINGRUNNING (197, "Key used to define the command <code>AudioStreamingRunning</code> of class <code>AudioState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>IntensityChanged</code> of class <code>HeadlightsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_HEADLIGHTSSTATE_INTENSITYCHANGED (198, "Key used to define the command <code>IntensityChanged</code> of class <code>HeadlightsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>List</code> of class <code>AnimationsState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_ANIMATIONSSTATE_LIST (199, "Key used to define the command <code>List</code> of class <code>AnimationsState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>SupportedAccessoriesListChanged</code> of class <code>AccessoryState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_ACCESSORYSTATE_SUPPORTEDACCESSORIESLISTCHANGED (200, "Key used to define the command <code>SupportedAccessoriesListChanged</code> of class <code>AccessoryState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>AccessoryConfigChanged</code> of class <code>AccessoryState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_ACCESSORYSTATE_ACCESSORYCONFIGCHANGED (201, "Key used to define the command <code>AccessoryConfigChanged</code> of class <code>AccessoryState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>AccessoryConfigModificationEnabled</code> of class <code>AccessoryState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_ACCESSORYSTATE_ACCESSORYCONFIGMODIFICATIONENABLED (202, "Key used to define the command <code>AccessoryConfigModificationEnabled</code> of class <code>AccessoryState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>MaxChargeRateChanged</code> of class <code>ChargerState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CHARGERSTATE_MAXCHARGERATECHANGED (203, "Key used to define the command <code>MaxChargeRateChanged</code> of class <code>ChargerState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>CurrentChargeStateChanged</code> of class <code>ChargerState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CHARGERSTATE_CURRENTCHARGESTATECHANGED (204, "Key used to define the command <code>CurrentChargeStateChanged</code> of class <code>ChargerState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>LastChargeRateChanged</code> of class <code>ChargerState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CHARGERSTATE_LASTCHARGERATECHANGED (205, "Key used to define the command <code>LastChargeRateChanged</code> of class <code>ChargerState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>ChargingInfo</code> of class <code>ChargerState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_CHARGERSTATE_CHARGINGINFO (206, "Key used to define the command <code>ChargingInfo</code> of class <code>ChargerState</code> in project <code>Common</code>"),
   /** Key used to define the command <code>RunIdChanged</code> of class <code>RunState</code> in project <code>Common</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMON_RUNSTATE_RUNIDCHANGED (207, "Key used to define the command <code>RunIdChanged</code> of class <code>RunState</code> in project <code>Common</code>"),
   /** Key used to define the feature <code>CommonDebug</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMONDEBUG (208, "Key used to define the feature <code>CommonDebug</code>"),
   /** Key used to define the command <code>SendPacket</code> of class <code>StatsEvent</code> in project <code>CommonDebug</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMONDEBUG_STATSEVENT_SENDPACKET (209, "Key used to define the command <code>SendPacket</code> of class <code>StatsEvent</code> in project <code>CommonDebug</code>"),
   /** Key used to define the command <code>Info</code> of class <code>DebugSettingsState</code> in project <code>CommonDebug</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMONDEBUG_DEBUGSETTINGSSTATE_INFO (210, "Key used to define the command <code>Info</code> of class <code>DebugSettingsState</code> in project <code>CommonDebug</code>"),
   /** Key used to define the command <code>ListChanged</code> of class <code>DebugSettingsState</code> in project <code>CommonDebug</code> */
    ARCONTROLLER_DICTIONARY_KEY_COMMONDEBUG_DEBUGSETTINGSSTATE_LISTCHANGED (211, "Key used to define the command <code>ListChanged</code> of class <code>DebugSettingsState</code> in project <code>CommonDebug</code>"),
   /** Key used to define the feature <code>Pro</code> */
    ARCONTROLLER_DICTIONARY_KEY_PRO (212, "Key used to define the feature <code>Pro</code>"),
   /** Key used to define the command <code>SupportedFeatures</code> of class <code>ProState</code> in project <code>Pro</code> */
    ARCONTROLLER_DICTIONARY_KEY_PRO_PROSTATE_SUPPORTEDFEATURES (213, "Key used to define the command <code>SupportedFeatures</code> of class <code>ProState</code> in project <code>Pro</code>"),
   /** Key used to define the command <code>FeaturesActivated</code> of class <code>ProState</code> in project <code>Pro</code> */
    ARCONTROLLER_DICTIONARY_KEY_PRO_PROSTATE_FEATURESACTIVATED (214, "Key used to define the command <code>FeaturesActivated</code> of class <code>ProState</code> in project <code>Pro</code>"),
   /** Key used to define the command <code>ChallengeEvent</code> of class <code>ProEvent</code> in project <code>Pro</code> */
    ARCONTROLLER_DICTIONARY_KEY_PRO_PROEVENT_CHALLENGEEVENT (215, "Key used to define the command <code>ChallengeEvent</code> of class <code>ProEvent</code> in project <code>Pro</code>"),
   /** Unused, iterator maximum value */
    ARCONTROLLER_DICTIONARY_DICTIONARY_KEY_MAX (216, "Unused, iterator maximum value");

    private final int value;
    private final String comment;
    static HashMap<Integer, ARCONTROLLER_DICTIONARY_KEY_ENUM> valuesList;

    ARCONTROLLER_DICTIONARY_KEY_ENUM (int value) {
        this.value = value;
        this.comment = null;
    }

    ARCONTROLLER_DICTIONARY_KEY_ENUM (int value, String comment) {
        this.value = value;
        this.comment = comment;
    }

    /**
     * Gets the int value of the enum
     * @return int value of the enum
     */
    public int getValue () {
        return value;
    }

    /**
     * Gets the ARCONTROLLER_DICTIONARY_KEY_ENUM instance from a C enum value
     * @param value C value of the enum
     * @return The ARCONTROLLER_DICTIONARY_KEY_ENUM instance, or null if the C enum value was not valid
     */
    public static ARCONTROLLER_DICTIONARY_KEY_ENUM getFromValue (int value) {
        if (null == valuesList) {
            ARCONTROLLER_DICTIONARY_KEY_ENUM [] valuesArray = ARCONTROLLER_DICTIONARY_KEY_ENUM.values ();
            valuesList = new HashMap<Integer, ARCONTROLLER_DICTIONARY_KEY_ENUM> (valuesArray.length);
            for (ARCONTROLLER_DICTIONARY_KEY_ENUM entry : valuesArray) {
                valuesList.put (entry.getValue (), entry);
            }
        }
        ARCONTROLLER_DICTIONARY_KEY_ENUM retVal = valuesList.get (value);
        if (retVal == null) {
            retVal = eARCONTROLLER_DICTIONARY_KEY_UNKNOWN_ENUM_VALUE;
        }
        return retVal;    }

    /**
     * Returns the enum comment as a description string
     * @return The enum description
     */
    public String toString () {
        if (this.comment != null) {
            return this.comment;
        }
        return super.toString ();
    }
}
