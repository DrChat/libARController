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

/**
 * @file ARCONTROLLER_Stream2.c
 * @brief ARCONTROLLER_Stream2 allow to operate Stream 2 for receive a stream.
 * @date 02/03/2015
 * @author maxime.maitre@parrot.com
 */
 
#include <stdlib.h>

#include <json/json.h>
#include <libARSAL/ARSAL_Print.h>
#include <libARSAL/ARSAL_Socket.h>
#include <libARSAL/ARSAL_Thread.h>
#include <libARDiscovery/ARDISCOVERY_Error.h>
#include <libARDiscovery/ARDISCOVERY_Device.h>
#include <libARController/ARCONTROLLER_Error.h>


#include <libARController/ARCONTROLLER_StreamPool.h>
#include <libARController/ARCONTROLLER_Stream.h>

#include "ARCONTROLLER_Stream2.h"
#include <libARController/ARCONTROLLER_Stream2.h>

/*************************
 * Private header
 *************************/

eARCONTROLLER_ERROR ARCONTROLLER_Stream2_StartBeaver (ARCONTROLLER_Stream2_t *stream2Controller);
eARCONTROLLER_ERROR ARCONTROLLER_Stream2_StopBeaver (ARCONTROLLER_Stream2_t *stream2Controller);
int ARCONTROLLER_Stream2_SpsPpsCallback(uint8_t *spsBuffer, int spsSize, uint8_t *ppsBuffer, int ppsSize, void *userPtr);
int ARCONTROLLER_Stream2_GetAuBufferCallback(uint8_t **auBuffer, int *auBufferSize, void **auBufferUserPtr, void *userPtr);
int ARCONTROLLER_Stream2_AuReadyCallback(uint8_t *auBuffer, int auSize, uint64_t auTimestamp, uint64_t auTimestampShifted, BEAVER_Filter_AuSyncType_t auSyncType, void *auMetadata, void *auBufferUserPtr, void *userPtr);

/*************************
 * Implementation
 *************************/

ARCONTROLLER_Stream2_t *ARCONTROLLER_Stream2_New (ARDISCOVERY_Device_t *discoveryDevice, eARCONTROLLER_ERROR *error)
{
    // -- Create a new Stream 2 Controller --

    //local declarations
    eARCONTROLLER_ERROR localError = ARCONTROLLER_OK;
    ARCONTROLLER_Stream2_t *stream2Controller =  NULL;
    
    // Check parameters
    if (discoveryDevice == NULL)
    {
        localError = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    // No Else: the checking parameters sets localError to ARNETWORK_ERROR_BAD_PARAMETER and stop the processing
    
    if (localError == ARCONTROLLER_OK)
    {
        // Create the Stream 2 Controller
        stream2Controller = malloc (sizeof (ARCONTROLLER_Stream2_t));
        if (stream2Controller != NULL)
        {
            stream2Controller->isRunning = 0;
            
            stream2Controller->serverAddress[0] = '\0';
            ARDISCOVERY_DEVICE_WifiGetIpAddress (discoveryDevice, stream2Controller->serverAddress, ARCONTROLLER_STREAM2_IP_SIZE);
            
            stream2Controller->clientStreamPort = ARCONTROLLER_STREAM2_CLIENT_STREAM_PORT;
            stream2Controller->clientControlPort = ARCONTROLLER_STREAM2_CLIENT_CONTROL_PORT;
            stream2Controller->serverStreamPort = 0;
            stream2Controller->serverControlPort = 0;
            stream2Controller->maxPaquetSize = 0;
            stream2Controller->maxLatency = 0;
            stream2Controller->maxNetworkLatency = 0;
            stream2Controller->maxBiterate = 0;
            stream2Controller->parmeterSets = NULL;
            
            stream2Controller->callbackData = NULL;
            stream2Controller->configDecoderCallback = NULL;
            stream2Controller->receiveFrameCallback = NULL;
        }
        else
        {
            localError = ARCONTROLLER_ERROR_ALLOC;
        }
    }
    
    // delete the Network Controller if an error occurred
    if (localError != ARCONTROLLER_OK)
    {
        ARCONTROLLER_Stream2_Delete (&stream2Controller);
    }
    // No else: skipped by an error 

    // Return the error
    if (error != NULL)
    {
        *error = localError;
    }
    // No else: error is not returned 

    return stream2Controller;
}

void ARCONTROLLER_Stream2_Delete (ARCONTROLLER_Stream2_t **stream2Controller)
{
    // -- Delete the Stream 2 Controller --

    if (stream2Controller != NULL)
    {
        if ((*stream2Controller) != NULL)
        {
            ARCONTROLLER_Stream2_Stop (*stream2Controller);

            free ((*stream2Controller)->parmeterSets);
            (*stream2Controller)->parmeterSets = NULL;
            
            free (*stream2Controller);
            (*stream2Controller) = NULL;
        }
    }
}

eARCONTROLLER_ERROR ARCONTROLLER_Stream2_Start (ARCONTROLLER_Stream2_t *stream2Controller)
{
    // -- Start to read the stream --

    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    
    // Check parameters
    if (stream2Controller == NULL)
    {
        error = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    // No Else: the checking parameters sets error to ARNETWORK_ERROR_BAD_PARAMETER and stop the processing
    
    if ((error == ARCONTROLLER_OK) && (!stream2Controller->isRunning))
    {
        stream2Controller->isRunning = 1;
        
        if (ARCONTROLLER_Stream2_IsInitilized(stream2Controller) != 0)
        {
            // create the frame pool
            stream2Controller->framePool = ARCONTROLLER_StreamPool_New (ARCONTROLLER_STREAM2_AU_ARRAY_SIZE, &error);
        }
        else
        {
            error = ARCONTROLLER_ERROR_INIT_STREAM;
        }
        
        if (error == ARCONTROLLER_OK)
        {
            error = ARCONTROLLER_Stream2_StartBeaver (stream2Controller);
        }
        
        if (error != ARCONTROLLER_OK)
        {
            ARCONTROLLER_Stream2_Stop (stream2Controller);
        }
    }
    
    return error;
}

eARCONTROLLER_ERROR ARCONTROLLER_Stream2_Stop (ARCONTROLLER_Stream2_t *stream2Controller)
{
    // -- Stop to read the stream --

    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    
    // Check parameters
    if (stream2Controller == NULL)
    {
        error = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    // No Else: the checking parameters sets error to ARNETWORK_ERROR_BAD_PARAMETER and stop the processing
    
    if ((error == ARCONTROLLER_OK) && (stream2Controller->isRunning))
    {
        stream2Controller->isRunning = 0;
        
        ARCONTROLLER_Stream2_StopBeaver (stream2Controller);
    }
    
    return error;
}

eARCONTROLLER_ERROR ARCONTROLLER_Stream2_SetCallbacks(ARCONTROLLER_Stream2_t *stream2Controller, ARCONTROLLER_Stream_ConfigDecoderCallback_t configDecoderCallback, ARCONTROLLER_Stream_DidReceiveFrameCallback_t receiveFrameCallback, void *customData)
{
    // -- Set Stream2 Callbacks --

    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    
    // Check parameters
    if (stream2Controller == NULL)
    {
        error = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    
    if (error == ARCONTROLLER_OK)
    {
        stream2Controller->callbackData = customData;
        stream2Controller->configDecoderCallback = configDecoderCallback;
        stream2Controller->receiveFrameCallback = receiveFrameCallback;
    }
    
    return error;
}

int ARCONTROLLER_Stream2_IsRunning (ARCONTROLLER_Stream2_t *stream2Controller, eARCONTROLLER_ERROR *error)
{
    // -- Get is running --

    eARCONTROLLER_ERROR localError = ARCONTROLLER_OK;
    int isRunning = 0;
    
    // Check parameters
    if (stream2Controller == NULL)
    {
        localError = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    
    if (localError == ARCONTROLLER_OK)
    {
        isRunning = stream2Controller->isRunning;
    }
    
    // Return the error
    if (error != NULL)
    {
        *error = localError;
    }
    // No else: Error is not returned 
    
    return isRunning;
}

/*****************************************
 *
 *             private implementation:
 *
 ****************************************/

eARDISCOVERY_ERROR ARCONTROLLER_Stream2_OnSendJson (ARCONTROLLER_Stream2_t *stream2Controller, json_object *jsonObj)
{
    // -- Connection callback to receive the Json --
    
    // local declarations
    eARDISCOVERY_ERROR error = ARDISCOVERY_OK;
    
    json_object *valueJsonObj = NULL;
    
    // Check parameters
    if ((jsonObj == NULL) ||
        (stream2Controller == NULL))
    {
        error = ARDISCOVERY_ERROR_BAD_PARAMETER;
    }
    
    if (error == ARDISCOVERY_OK)
    {
        // add ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_CLIENT_STREAM_PORT_KEY
        valueJsonObj = json_object_new_int (stream2Controller->clientStreamPort);
        json_object_object_add (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_CLIENT_STREAM_PORT_KEY, valueJsonObj);
        
        // add ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_CLIENT_CONTROL_PORT_KEY
        valueJsonObj = json_object_new_int (stream2Controller->clientControlPort);
        json_object_object_add (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_CLIENT_CONTROL_PORT_KEY, valueJsonObj);
    }
    
    return error;
}

eARDISCOVERY_ERROR ARCONTROLLER_Stream2_OnReceiveJson (ARCONTROLLER_Stream2_t *stream2Controller, json_object *jsonObj)
{
    // -- Connection callback to receive the Json --
    
    // local declarations
    eARDISCOVERY_ERROR error = ARDISCOVERY_OK;
    eARCONTROLLER_ERROR controllerError = ARCONTROLLER_OK;
    
    json_object *valueJsonObj = NULL;
    
    if ((jsonObj == NULL) ||
        (stream2Controller == NULL))
    {
        error = ARDISCOVERY_ERROR_BAD_PARAMETER;
    }
    
    if (error == ARDISCOVERY_OK)
    {
        // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_STREAM_PORT_KEY
        valueJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_STREAM_PORT_KEY);
        if (valueJsonObj != NULL)
        {
            stream2Controller->serverStreamPort = json_object_get_int(valueJsonObj);
        }
        // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_CONTROL_PORT_KEY
        valueJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_CONTROL_PORT_KEY);
        if (valueJsonObj != NULL)
        {
            stream2Controller->serverControlPort = json_object_get_int(valueJsonObj);
        }
        
        // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_PACKET_SIZE_KEY
        valueJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_PACKET_SIZE_KEY);
        if (valueJsonObj != NULL)
        {
            stream2Controller->maxPaquetSize = json_object_get_int(valueJsonObj);
        }
        
        // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_LATENCY_KEY
        valueJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_LATENCY_KEY);
        if (valueJsonObj != NULL)
        {
            stream2Controller->maxLatency = json_object_get_int(valueJsonObj);
        }
        
        // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_NETWORK_LATENCY_KEY
        valueJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_NETWORK_LATENCY_KEY);
        if (valueJsonObj != NULL)
        {
            stream2Controller->maxNetworkLatency = json_object_get_int(valueJsonObj);
        }
        
        // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_BITRATE_KEY
        valueJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_MAX_BITRATE_KEY);
        if (valueJsonObj != NULL)
        {
            stream2Controller->maxBiterate = json_object_get_int(valueJsonObj);
        }
        
        // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_PARAMETER_SETS_KEY
        valueJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_PARAMETER_SETS_KEY);
        if (valueJsonObj != NULL)
        {
            int parmeterSetsLength = strlen(json_object_get_string(valueJsonObj));
            stream2Controller->parmeterSets = malloc (parmeterSetsLength + 1); //add 1 for '\0'
            
            if (stream2Controller->parmeterSets != NULL)
            {
                strncpy(stream2Controller->parmeterSets, json_object_get_string(valueJsonObj), parmeterSetsLength);
            }
            else
            {
                error = ARDISCOVERY_ERROR_ALLOC;
            }
        }
    }
    
    return error;
}

uint8_t ARCONTROLLER_Stream2_JsonContainsStream2Param(json_object *jsonObj)
{
    // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_STREAM_PORT_KEY
    json_object *serverStreamPortJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_STREAM_PORT_KEY);

    // get ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_CONTROL_PORT_KEY
    json_object *serverControlPortJsonObj = json_object_object_get (jsonObj, ARDISCOVERY_CONNECTION_JSON_ARSTREAM2_SERVER_CONTROL_PORT_KEY);
    
    return ((serverStreamPortJsonObj != NULL) && (serverStreamPortJsonObj != NULL));
}

int ARCONTROLLER_Stream2_IsInitilized (ARCONTROLLER_Stream2_t *stream2Controller)
{
    // Checks if the stream 2 manager is initialized.
    return ((stream2Controller->serverStreamPort != 0) && (stream2Controller->serverControlPort != 0));
}

/*****************************************
 *
 *             local implementation:
 *
 ****************************************/

eARCONTROLLER_ERROR ARCONTROLLER_Stream2_StartBeaver (ARCONTROLLER_Stream2_t *stream2Controller)
{
    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    BEAVER_ReaderFilter_Config_t config;
    int beaverError = 0;
    
    // Check parameters
    if (stream2Controller == NULL)
    {
        error = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    // No Else: the checking parameters sets error to ARNETWORK_ERROR_BAD_PARAMETER and stop the processing
    
    if (error == ARCONTROLLER_OK)
    {
        memset(&config, 0, sizeof(BEAVER_ReaderFilter_Config_t));
        
        config.serverAddr = stream2Controller->serverAddress; //TODO get from discovery device 
        config.mcastAddr = NULL;
        config.mcastIfaceAddr = NULL;
        config.serverStreamPort = stream2Controller->serverStreamPort;
        config.serverControlPort = stream2Controller->serverControlPort;
        config.clientStreamPort = stream2Controller->clientStreamPort;
        config.clientControlPort = stream2Controller->clientControlPort;
        config.maxPacketSize = stream2Controller->maxPaquetSize;
        config.maxBitrate = stream2Controller->maxBiterate;
        config.maxLatencyMs = stream2Controller->maxLatency;
        config.maxNetworkLatencyMs = stream2Controller->maxNetworkLatency;
        config.waitForSync = 1;
        config.outputIncompleteAu = 0;
        config.filterOutSpsPps = 1;
        config.filterOutSei = 1;
        config.replaceStartCodesWithNaluSize = 0;
        config.generateSkippedPSlices = 1;
        config.generateFirstGrayIFrame = 1;
        
        
    }
        
    if (error == ARCONTROLLER_OK)
    {
        beaverError = BEAVER_ReaderFilter_Init(&(stream2Controller->readerFilterHandle), &config);
        if (beaverError)
        {
            error = ARCONTROLLER_ERROR_INIT_STREAM;
            ARSAL_PRINT(ARSAL_PRINT_ERROR, ARCONTROLLER_STREAM2_TAG, "Error BEAVER_ReaderFilter_Init : %d", beaverError);
        }
    }
    
    if (error == ARCONTROLLER_OK)
    {
        if (ARSAL_Thread_Create(&(stream2Controller->runStreamThread), BEAVER_ReaderFilter_RunStreamThread, stream2Controller->readerFilterHandle) != 0)
        {
            ARSAL_PRINT(ARSAL_PRINT_ERROR, ARCONTROLLER_STREAM2_TAG, "Creation of Stream thread failed.");
            error = ARCONTROLLER_ERROR_INIT_THREAD;
        }
    }
    
    if (error == ARCONTROLLER_OK)
    {
        if (ARSAL_Thread_Create(&(stream2Controller->runControllerThread), BEAVER_ReaderFilter_RunControlThread, stream2Controller->readerFilterHandle) != 0)
        {
            ARSAL_PRINT(ARSAL_PRINT_ERROR, ARCONTROLLER_STREAM2_TAG, "Creation of Controller thread failed.");
            error = ARCONTROLLER_ERROR_INIT_THREAD;
        }
    }
    
    if (error == ARCONTROLLER_OK)
    {
        if (ARSAL_Thread_Create(&(stream2Controller->runFilterThread), BEAVER_ReaderFilter_RunFilterThread, stream2Controller->readerFilterHandle) != 0)
        {
            ARSAL_PRINT(ARSAL_PRINT_ERROR, ARCONTROLLER_STREAM2_TAG, "Creation of Filter thread failed.");
            error = ARCONTROLLER_ERROR_INIT_THREAD;
        }
    }
    
    if (error == ARCONTROLLER_OK)
    {
        beaverError = BEAVER_ReaderFilter_StartFilter (stream2Controller->readerFilterHandle, ARCONTROLLER_Stream2_SpsPpsCallback, stream2Controller, ARCONTROLLER_Stream2_GetAuBufferCallback, stream2Controller, ARCONTROLLER_Stream2_AuReadyCallback, stream2Controller);
        
        if (beaverError)
        {
            error = ARCONTROLLER_ERROR_INIT_STREAM;
            ARSAL_PRINT(ARSAL_PRINT_ERROR, ARCONTROLLER_STREAM2_TAG, "Error BEAVER_ReaderFilter_StartFilter : %d", beaverError);
        }
    }
    
    return error;
}


eARCONTROLLER_ERROR ARCONTROLLER_Stream2_StopBeaver (ARCONTROLLER_Stream2_t *stream2Controller)
{
    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    
    // Check parameters
    if (stream2Controller == NULL)
    {
        error = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    // No Else: the checking parameters sets error to ARNETWORK_ERROR_BAD_PARAMETER and stop the processing
    
    if (error == ARCONTROLLER_OK)
    {
        BEAVER_ReaderFilter_Stop(stream2Controller->readerFilterHandle);
        
        if (stream2Controller->runStreamThread!= NULL)
        {
            ARSAL_Thread_Join(stream2Controller->runStreamThread, NULL);
            ARSAL_Thread_Destroy(&(stream2Controller->runStreamThread));
            stream2Controller->runStreamThread = NULL;
        }
        
        if (stream2Controller->runControllerThread!= NULL)
        {
            ARSAL_Thread_Join(stream2Controller->runControllerThread, NULL);
            ARSAL_Thread_Destroy(&(stream2Controller->runControllerThread));
            stream2Controller->runControllerThread = NULL;
        }
        
        if (stream2Controller->runFilterThread!= NULL)
        {
            ARSAL_Thread_Join(stream2Controller->runFilterThread, NULL);
            ARSAL_Thread_Destroy(&(stream2Controller->runFilterThread));
            stream2Controller->runFilterThread = NULL;
        }
        
        BEAVER_ReaderFilter_Free(&(stream2Controller->readerFilterHandle));
    }
    
    return error;
}

eARCONTROLLER_ERROR ARCONTROLLER_Stream2_RestartBeaver (ARCONTROLLER_Stream2_t *stream2Controller)
{
    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    
    // Check parameters
    if (stream2Controller == NULL)
    {
        error = ARCONTROLLER_ERROR_BAD_PARAMETER;
    }
    // No Else: the checking parameters sets error to ARNETWORK_ERROR_BAD_PARAMETER and stop the processing
    
    if (error == ARCONTROLLER_OK)
    {
        error = ARCONTROLLER_Stream2_StopBeaver (stream2Controller);
    }
    
    if (error == ARCONTROLLER_OK)
    {
        error = ARCONTROLLER_Stream2_StartBeaver (stream2Controller);
    }
    
    return error;
}

int ARCONTROLLER_Stream2_SpsPpsCallback(uint8_t *spsBuffer, int spsSize, uint8_t *ppsBuffer, int ppsSize, void *userPtr)
{
    ARCONTROLLER_Stream2_t *stream2Controller = (ARCONTROLLER_Stream2_t *)userPtr;
    
    
    if(stream2Controller->configDecoderCallback != NULL)
    {
        ARCONTROLLER_Stream_Codec_t codec;
        codec.type = ARCONTROLLER_STREAM_CODEC_TYPE_H264;
        codec.parmeters.h264parmeters.spsBuffer = spsBuffer;
        codec.parmeters.h264parmeters.spsSize = spsSize;
        codec.parmeters.h264parmeters.ppsBuffer = ppsBuffer;
        codec.parmeters.h264parmeters.ppsSize = ppsSize;
        
        stream2Controller->configDecoderCallback(codec, stream2Controller->callbackData);
    }
    
    return 0;
}

int ARCONTROLLER_Stream2_GetAuBufferCallback(uint8_t **auBuffer, int *auBufferSize, void **auBufferUserPtr, void *userPtr)
{
    ARCONTROLLER_Stream2_t *stream2Controller = (ARCONTROLLER_Stream2_t *)userPtr;
    
    int retVal = -1;
    
    eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
    
    ARCONTROLLER_Frame_t *frame = ARCONTROLLER_StreamPool_GetNextFreeFrame (stream2Controller->framePool, &error);
    
    if (error == ARCONTROLLER_OK)
    {
        *auBuffer = frame->data;
        *auBufferSize = frame->capacity;
        *auBufferUserPtr = frame;
        
        frame->available = 0;
        
        retVal = 0;
    }
    else
    {
        ARSAL_PRINT(ARSAL_PRINT_ERROR, ARCONTROLLER_STREAM2_TAG, "ARCONTROLLER_Stream2_GetAuBuffer ERROR NO BUFFER available");
    }
    
    return retVal;
}

int ARCONTROLLER_Stream2_AuReadyCallback(uint8_t *auBuffer, int auSize, uint64_t auTimestamp, uint64_t auTimestampShifted, BEAVER_Filter_AuSyncType_t auSyncType, void *auMetadata, void *auBufferUserPtr, void *userPtr)
{
    ARCONTROLLER_Stream2_t *stream2Controller = (ARCONTROLLER_Stream2_t *)userPtr;
    ARCONTROLLER_Frame_t *frame = (ARCONTROLLER_Frame_t *) auBufferUserPtr;
    
    //callback
    if ((frame != NULL) && (stream2Controller->receiveFrameCallback != NULL))
    {
        //set frame size
        frame->used = auSize;

        //set frame type
        if (auSyncType == BEAVER_FILTER_AU_SYNC_TYPE_IFRAME)
        {
            frame->isIFrame = 1;
        }
        
        stream2Controller->receiveFrameCallback(frame, stream2Controller->callbackData);
        
        frame->available = 1;
    }

    return 0;
}
