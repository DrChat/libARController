/*
    Copyright (C) 2016 Parrot SA

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
 * @file ARCONTROLLER_NAckCbs.c
 * @brief Callback for the algorithmic to send non acknowledged commands.
 */

#include <stdlib.h>

#include <libARController/ARCONTROLLER_Error.h>
#include <ARCONTROLLER_Feature.h>
#include "ARCONTROLLER_NAckCbs.h"

/*************************
 * Private header
 *************************/

/*************************
 * Implementation
 *************************/

struct ARDrone3CameraOrientationData {
	uint32_t sending_count;
	uint8_t cmd_version;
};

/* ARDrone3 CameraOrientation */
eARCONTROLLER_ERROR ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationInit(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	return ARCONTROLLER_OK;
}

eARCONTROLLER_ERROR ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationDeInit(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	return ARCONTROLLER_OK;
}

void ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationChanged(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraOrientationData *data = NULL;

	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraOrientationParameters == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters->data == NULL))
		return;

	data = feature->privatePart->CameraOrientationV2Parameters->data;
	data->sending_count = 0;

	if (data->cmd_version > 1) {
		/* Copy values in command CameraOrientation v2 */
		feature->privatePart->CameraOrientationV2Parameters->tilt = (float)
				feature->privatePart->CameraOrientationParameters->tilt;
		feature->privatePart->CameraOrientationV2Parameters->pan = (float)
				feature->privatePart->CameraOrientationParameters->pan;
	}
}

uint8_t ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationMustBeSent(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraOrientationData *data = NULL;

	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters->data == NULL))
		return 0;

	data = feature->privatePart->CameraOrientationV2Parameters->data;

	if (data->cmd_version != 1)
		return 0;

	if (data->sending_count < 10) {
		data->sending_count++;
		return 1;
	}

	return 0;
}

/* ARDrone3 CameraOrientationV2 */
static void cameraStateOrientationCb (eARCONTROLLER_DICTIONARY_KEY commandKey,
		ARCONTROLLER_DICTIONARY_ELEMENT_t *elementDictionary, void *customData)
{
	struct ARDrone3CameraOrientationData *data = customData;

	if (data == NULL)
		return;

	switch(commandKey) {
	case ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_ORIENTATION:
		if (data->cmd_version < 1)
			data->cmd_version = 1;
		break;
	case ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_ORIENTATIONV2:
		if (data->cmd_version < 2)
			data->cmd_version = 2;
		break;
	default:
		break;
	}
}

eARCONTROLLER_ERROR ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationV2Init(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraOrientationData *data = NULL;
	eARCONTROLLER_ERROR error = ARCONTROLLER_OK;
	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters == NULL))
		return ARCONTROLLER_ERROR_BAD_PARAMETER;

	data = calloc(1, sizeof(*data));
	if (data == NULL)
		return ARCONTROLLER_ERROR_ALLOC;

	feature->privatePart->CameraOrientationV2Parameters->data = data;

	/* Set CameraOrientation callbacks */
	error = ARCONTROLLER_FEATURE_ARDrone3_AddCallback (feature,
			ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_ORIENTATION,
			&cameraStateOrientationCb, data);
	if (error != ARCONTROLLER_OK)
		return error;

	error = ARCONTROLLER_FEATURE_ARDrone3_AddCallback (feature,
			ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_ORIENTATIONV2,
			&cameraStateOrientationCb, data);
	if (error != ARCONTROLLER_OK)
		return error;

	return ARCONTROLLER_OK;
}
eARCONTROLLER_ERROR ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationV2DeInit(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraOrientationData *data = NULL;

	if ((feature == NULL)||
	    (feature->privatePart == NULL) ||
	    (feature->privatePart->CameraOrientationV2Parameters == NULL))
		return ARCONTROLLER_ERROR_BAD_PARAMETER;

	data = feature->privatePart->CameraOrientationV2Parameters->data;

	/* Remove CameraOrientation callbacks */
	ARCONTROLLER_FEATURE_ARDrone3_RemoveCallback (feature,
			ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_ORIENTATION,
			&cameraStateOrientationCb, data);
	ARCONTROLLER_FEATURE_ARDrone3_RemoveCallback (feature,
			ARCONTROLLER_DICTIONARY_KEY_ARDRONE3_CAMERASTATE_ORIENTATIONV2,
			&cameraStateOrientationCb, data);

	free(feature->privatePart->CameraOrientationV2Parameters->data);
	feature->privatePart->CameraOrientationV2Parameters->data = NULL;

	return ARCONTROLLER_OK;
}

void ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationV2Changed(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraOrientationData *data = NULL;

	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraOrientationParameters == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters->data == NULL))
		return;

	data = feature->privatePart->CameraOrientationV2Parameters->data;
	data->sending_count = 0;

	if (data->cmd_version < 2) {
		/* Copy values in command CameraOrientation v1 */
		feature->privatePart->CameraOrientationParameters->tilt = (int8_t)
				feature->privatePart->CameraOrientationV2Parameters->tilt;
		feature->privatePart->CameraOrientationParameters->pan = (int8_t)
				feature->privatePart->CameraOrientationV2Parameters->pan;
	}
}
uint8_t ARCONTROLLER_NAckCbs_ARDrone3CameraOrientationV2MustBeSent(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraOrientationData *data = NULL;

	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters == NULL) ||
		(feature->privatePart->CameraOrientationV2Parameters->data == NULL))
		return 0;

	data = feature->privatePart->CameraOrientationV2Parameters->data;

	if (data->cmd_version != 2)
		return 0;

	if (data->sending_count < 10) {
		data->sending_count++;
		return 1;
	}

	return 0;
}


/* ARDrone3 CameraVelocity */
struct ARDrone3CameraVelocityData {
	uint8_t val_is_null;
	uint32_t sending_count;
};

eARCONTROLLER_ERROR ARCONTROLLER_NAckCbs_ARDrone3CameraVelocityInit(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraVelocityData *data = NULL;
	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraVelocityParameters == NULL))
		return ARCONTROLLER_ERROR_BAD_PARAMETER;

	data = calloc(1, sizeof(*data));
	if (data == NULL)
		return ARCONTROLLER_ERROR_ALLOC;

	feature->privatePart->CameraVelocityParameters->data = data;

	return ARCONTROLLER_OK;
}
eARCONTROLLER_ERROR ARCONTROLLER_NAckCbs_ARDrone3CameraVelocityDeInit(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	if ((feature == NULL)||
	(feature->privatePart == NULL) ||
	(feature->privatePart->CameraVelocityParameters == NULL))
	return ARCONTROLLER_ERROR_BAD_PARAMETER;

	free(feature->privatePart->CameraVelocityParameters->data);
	feature->privatePart->CameraVelocityParameters->data = NULL;

	return ARCONTROLLER_OK;
}
void ARCONTROLLER_NAckCbs_ARDrone3CameraVelocityChanged(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraVelocityData *data = NULL;

	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraVelocityParameters == NULL) ||
		(feature->privatePart->CameraVelocityParameters->data == NULL))
		return;

	data = feature->privatePart->CameraVelocityParameters->data;
	if ((feature->privatePart->CameraVelocityParameters->tilt == 0) &&
	    (feature->privatePart->CameraVelocityParameters->pan == 0)) {
		data->val_is_null = 1;
		data->sending_count = 0;
	} else {
		data->val_is_null = 0;
	}
}
uint8_t ARCONTROLLER_NAckCbs_ARDrone3CameraVelocityMustBeSent(
		ARCONTROLLER_FEATURE_ARDrone3_t *feature)
{
	struct ARDrone3CameraVelocityData *data = NULL;

	if ((feature == NULL)||
		(feature->privatePart == NULL) ||
		(feature->privatePart->CameraVelocityParameters == NULL) ||
		(feature->privatePart->CameraVelocityParameters->data == NULL))
		return 0;

	data = feature->privatePart->CameraVelocityParameters->data;

	if (!data->val_is_null)
		return 1;

	if (data->sending_count < 10) {
		data->sending_count++;
		return 1;
	}

	return 0;
}
