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

import org.eclipse.ecsp.annotations.EventMapping;

import java.util.Map;

/**
 * This class stores the event exception related information during DLQ re-processing.
 *
 * @author MaKumari
 */
@SuppressWarnings("checkstyle:TypeName")
@EventMapping(id = EventID.IGNITE_EXCEPTION_EVENT, version = Version.V1_1)
public class IgniteExceptionDataV1_1 extends AbstractIgniteExceptionData {

    private static final long serialVersionUID = 1L;
    /**
     * Stage at which event failed.
     */
    private String processorName;
    /**
     * Number of times when the failed event is reprocessed.
     */
    private int retryCount;
    /**
     * This attribute is used to store the previous nested exception
     * event incase of re-processing of failed events so that more informed
     * decision can be made during analysis.
     */
    private NestedDLQExceptionData nestedDLQExceptionData;

    /**
     * Context is used to store the necessary stage info where failure
     * occurred so that in the next re-run, processing should be resumed
     * from the same stage. The purpose behind this feature is to avoid the
     * inconsistency in case persistence was involved and event
     * failed.
     */
    private transient Map<String, Object> context;

    /**
     * Default constructor.
     */
    public IgniteExceptionDataV1_1() {
        super();
    }

    /**
     * This method is a getter for processorname.
     *
     * @return String
     */
    public String getProcessorName() {
        return processorName;
    }

    /**
     * This method is a setter for processorname.
     *
     * @param processorName : String
     */
    public void setProcessorName(String processorName) {
        this.processorName = processorName;
    }

    /**
     * This method is a getter for retrycount.
     *
     * @return int
     */
    public int getRetryCount() {
        return retryCount;
    }

    /**
     * This method is a setter for retrycount.
     *
     * @param retryCount : int
     */
    public void setRetryCount(int retryCount) {
        this.retryCount = retryCount;
    }

    /**
     * This method is a getter for nesteddlqexceptiondata.
     *
     * @return NestedDLQExceptionData
     */
    public NestedDLQExceptionData getNestedDLQExceptionData() {
        return nestedDLQExceptionData;
    }

    /**
     * This method is a setter for nesteddlqexceptiondata.
     *
     * @param nestedDLQExceptionData : NestedDLQExceptionData
     */
    public void setNestedDLQExceptionData(NestedDLQExceptionData nestedDLQExceptionData) {
        this.nestedDLQExceptionData = nestedDLQExceptionData;
    }

    /**
     * This method is a getter for context.
     *
     * @return Map{@code <}String{@code >}{@code <}Object{@code >}
     */
    public Map<String, Object> getContext() {
        return context;
    }

    /**
     * This method is a setter for context.
     *
     * @param context : Map{@code <}String{@code >}{@code <}Object{@code >}
     */
    public void setContext(Map<String, Object> context) {
        this.context = context;
    }

    @Override
    public String toString() {
        return "IgniteExceptionDataV1_1 [processorName=" + processorName
                + ", retryCount=" + retryCount
                + ", nestedDLQExceptionData=" + nestedDLQExceptionData + ", context=" + context + "]";
    }

}