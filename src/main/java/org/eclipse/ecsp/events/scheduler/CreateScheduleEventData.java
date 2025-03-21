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

package org.eclipse.ecsp.events.scheduler;

import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.StringUtils;
import org.eclipse.ecsp.annotations.EventMapping;
import org.eclipse.ecsp.domain.EventID;
import org.eclipse.ecsp.domain.Version;
import org.eclipse.ecsp.entities.AbstractEventData;
import org.eclipse.ecsp.key.IgniteStringKey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * CreateScheduleEvent Class is used to initiate scheduled events.
 *
 * @author VKanchepalli
 */
@EventMapping(id = EventID.CREATE_SCHEDULE_EVENT, version = Version.V1_0)
@EqualsAndHashCode
public class CreateScheduleEventData extends AbstractEventData {
    
    /**
     * uid.
     */
    private static final long serialVersionUID = -3736798123313255986L;
    /**
     * Initial delay time in milli seconds for the first schedule. Mandatory.
     */
    private long initialDelayMs;
    /**
     * Recurrence type to be used to calculate the delay for recurring schedule.
     */
    private RecurrenceType recurrenceType = RecurrenceType.CUSTOM_MS;
    /**
     * Arbitrary delay time in milli seconds for recurring schedules.
     * Applicable only when recurrence type is CUSTOM_MS and firingCount > 1
     * i.e., recurring schedule. Not Mandatory.
     */
    private long recurrenceDelayMs;
    /**
     * No of times to execute the schedule. Mandatory.
     */
    private int firingCount;
    /**
     * Payload data. Mandatory.
     */
    private byte[] notificationPayload;
    /**
     * Ignite notification key. Mandatory. This has to be set by the service with the
     * IgniteKey that it receives from kafka topic.
     * <p>
     * This is of type IgniteStringKey to comply with Jackson's deserializer requirement.
     * </p>
     */
    private IgniteStringKey notificationKey;
    /**
     * Kafkatopic in which ScheduleOpStatusEvent and ScheduledNotificationEvent will be published. Mandatory.
     */
    private String notificationTopic;
    /**
     * Stores name of service. Mandatory.
     */
    private String serviceName;


    /**
     * get recurrenceDelayMs.
     *
     * @return long
     */
    public long getRecurrenceDelayMs() {
        return recurrenceDelayMs;
    }

    /**
     * set recurrenceDelayMs.
     *
     * @param recurrenceDelayMs : long
     */
    public void setRecurrenceDelayMs(long recurrenceDelayMs) {
        this.recurrenceDelayMs = recurrenceDelayMs;
    }

    /**
     * get initialDelayMs.
     *
     * @return long
     */
    public long getInitialDelayMs() {
        return initialDelayMs;
    }

    /**
     * set initialDelayMs.
     *
     * @param initialDelayMs : long
     */
    public void setInitialDelayMs(long initialDelayMs) {
        this.initialDelayMs = initialDelayMs;
    }

    /**
     * get recurrenceType.
     *
     * @return RecurrenceType
     */
    public RecurrenceType getRecurrenceType() {
        return recurrenceType;
    }

    /**
     * set recurrenceType.
     *
     * @param recurrenceType : RecurrenceType
     */
    public void setRecurrenceType(RecurrenceType recurrenceType) {
        this.recurrenceType = recurrenceType;
    }

    /**
     * get firingCount.
     *
     * @return int
     */
    public int getFiringCount() {
        return firingCount;
    }

    /**
     * get firingCount.
     *
     * @param firingCount : int
     */
    public void setFiringCount(int firingCount) {
        this.firingCount = firingCount;
    }

    /**
     * get notificationPayload.
     *
     * @return byte[]
     */
    public byte[] getNotificationPayload() {
        return notificationPayload;
    }

    /**
     * set notificationPayload.
     *
     * @param notificationPayload : byte[]
     */
    public void setNotificationPayload(byte[] notificationPayload) {
        this.notificationPayload = notificationPayload;
    }

    /**
     * get notificationKey.
     *
     * @return IgniteStringKey
     */
    public IgniteStringKey getNotificationKey() {
        return notificationKey;
    }

    /**
     * set notificationKey.
     *
     * @param notificationKey : IgniteStringKey
     */
    public void setNotificationKey(IgniteStringKey notificationKey) {
        this.notificationKey = notificationKey;
    }

    /**
     * get notificationTopic.
     *
     * @return String
     */
    public String getNotificationTopic() {
        return notificationTopic;
    }

    /**
     * set notificationTopic.
     *
     * @param notificationTopic : String
     */
    public void setNotificationTopic(String notificationTopic) {
        this.notificationTopic = notificationTopic;
    }

    /**
     * get serviceName.
     *
     * @return String
     */
    public String getServiceName() {
        return serviceName;
    }

    /**
     * set serviceName.
     *
     * @param serviceName : String
     */
    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    /**
     * Validate the mandatory fields. This has to be called by SchedulerService explicitly before processing.
     *
     * @return true/false
     */
    public boolean validate() {
        boolean valid = true;

        List<String> invalidFields = new ArrayList<>();

        // recurrenceDelayMs is applicable only for recurring schedule with
        // recurrence type as custom delay and firing count is more than 1
        // i.e., recurrenceType = CUSTOM_MS and firingCount > 1
        if (RecurrenceType.CUSTOM_MS.equals(recurrenceType)
                && ((firingCount > 1 && recurrenceDelayMs <= 0) || (firingCount == 1 && recurrenceDelayMs > 0))) {
            invalidFields.add("recurrenceDelayMs");
        }

        if (initialDelayMs <= 0) {
            invalidFields.add("initialDelayMs");
        }

        if (firingCount < 1) {
            invalidFields.add("firingCount");
        }

        if (notificationPayload == null || notificationPayload.length == 0) {
            invalidFields.add("notificationPayload");
        }

        if (notificationKey == null) {
            invalidFields.add("notificationKey");
        }

        if (StringUtils.isEmpty(notificationTopic)) {
            invalidFields.add("notificationTopic");
        }

        if (StringUtils.isEmpty(serviceName)) {
            invalidFields.add("serviceName");
        }

        if (!invalidFields.isEmpty()) {
            valid = false;
        }

        return valid;
    }

    @Override
    public String toString() {
        return "CreateScheduleData [initialDelayMs=" + initialDelayMs
                + ", recurrenceType=" + recurrenceType + ", recurrenceDelayMs=" + recurrenceDelayMs
                + ", firingCount=" + firingCount
                + ", notificationPayload=" + Arrays.toString(notificationPayload)
                + ", notificationKey=" + notificationKey
                + ", notificationTopic=" + notificationTopic + ", serviceName=" + serviceName + "]";
    }

    /**
     * Specifies the interval at which the schedule recurs after the first firing.
     * Possible options, use custom delay ms or standard
     * periodic intervals.
     *
     * <p>
     * CUSTOM_MS: Use arbitrary delay time as recurrence interval specified for recurrenceDelayMs attribute.
     * YEARLY or MONTHLY or DAILY or HOURLY or EVERY_MINUTE or EVERY_SECOND:
     * Use delay corresponding to time interval of one calendar year
     * (leap/non-leap) or calendar month (even/odd and leap/non-leap) or a day or an hour or a minute or a second time.
     * </p>
     */
    public enum RecurrenceType {
        /**
         * Yearly.
         */
        YEARLY, 
        /**
         * Monthly.
         */
        MONTHLY, 
        /**
         * Daily.
         */
        DAILY, 
        /**
         * Hourly.
         */
        HOURLY, 
        /**
         * every minute.
         */
        EVERY_MINUTE, 
        /**
         * every second.
         */
        EVERY_SECOND, 
        /**
         * custom.
         */
        CUSTOM_MS;
    }
}
