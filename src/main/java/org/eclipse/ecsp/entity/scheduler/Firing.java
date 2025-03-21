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

package org.eclipse.ecsp.entity.scheduler;

import dev.morphia.annotations.Entity;

/**
 * The class stores the timestamp at which schedule was fired.
 *
 * @author VKanchepalli
 */
@Entity(useDiscriminator = false)
public class Firing {

    /**
     * timestamp in milliseconds at which scheduler works.
     */
    private long timeMs;

    /**
     * default constructor.
     */
    public Firing() {
        super();
    }

    /**
     * Initialize with timeMs.
     *
     * @param timeMs : long
     */
    public Firing(long timeMs) {
        this.timeMs = timeMs;
    }

    /**
     * get timeMs.
     *
     * @return long
     */
    public long getTimeMs() {
        return timeMs;
    }

    /**
     * Sets TimeMS.
     *
     * @param timeMs : timeMs
     */
    public void setTimeMs(long timeMs) {
        this.timeMs = timeMs;
    }

    @Override
    public String toString() {
        return "Firing [timeMs=" + timeMs + "]";
    }
}
