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

package org.eclipse.ecsp.domain;

import lombok.EqualsAndHashCode;
import org.eclipse.ecsp.entities.AbstractEventData;

/**
 * Abstract speed event data.
 */
@EqualsAndHashCode
public abstract class AbstractSpeedEventData extends AbstractEventData {

    /**
     * version uid.
     */
    private static final long serialVersionUID = 8671602711617275715L;

    /**
     * value.
     */
    private double value;

    /**
     * get value.
     *
     * @return double
     */
    public double getValue() {
        return value;
    }

    /**
     * set value.
     *
     * @param value : double
     */
    public void setValue(double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "SpeedV1_0 [value=" + value + "]";
    }

}
