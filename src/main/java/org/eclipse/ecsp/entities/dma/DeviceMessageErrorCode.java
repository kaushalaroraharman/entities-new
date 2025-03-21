/*
 * *******************************************************************************
 *
 *  Copyright (c) 2023-24 Harman International
 *
 *
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *
 *  you may not use this file except in compliance with the License.
 *
 *  You may obtain a copy of the License at
 *
 *
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *       
 *
 *  Unless required by applicable law or agreed to in writing, software
 *
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *
 *  See the License for the specific language governing permissions and
 *
 *  limitations under the License.
 *
 *
 *
 *  SPDX-License-Identifier: Apache-2.0
 *
 *  *******************************************************************************
 */

package org.eclipse.ecsp.entities.dma;

/**
 * The enum Device message error code.
 */
public enum DeviceMessageErrorCode {
    /**
     * RETRY_ATTEMPTS_EXCEEDED.
     */
    RETRY_ATTEMPTS_EXCEEDED,
    /**
     * RETRYING_DEVICE_MESSAGE.
     */
    RETRYING_DEVICE_MESSAGE,
    /**
     * SHOULDER_TAP_RETRY_ATTEMPTS_EXCEEDED.
     */
    SHOULDER_TAP_RETRY_ATTEMPTS_EXCEEDED,
    /**
     * RETRYING_SHOULDER_TAP.
     */
    RETRYING_SHOULDER_TAP,
    /**
     * DEVICE_DELIVERY_CUTOFF_EXCEEDED.
     */
    DEVICE_DELIVERY_CUTOFF_EXCEEDED,
    /**
     * DEVICE_STATUS_INACTIVE.
     */
    DEVICE_STATUS_INACTIVE,
    /**
     * MQTT_DISPATCH_FAILED.
     */
    MQTT_DISPATCH_FAILED,
    /**
     * KAFKA_DISPATCH_FAILED.
     */
    KAFKA_DISPATCH_FAILED;
}
