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

package org.eclipse.ecsp.utils;

import org.apache.commons.lang3.StringUtils;

import static org.eclipse.ecsp.utils.Constants.ASTRIX;

/**
 * Utility class to hold common operations.
 *
 * @author mmenon
 */
public class Utils {
    private Utils() {
    }

    /**
     * Method to mask the data. The first half of the data will be masked with "*".
     *
     * <pre>
     * Utils.maskString("a")) == "*"
     * Utils.maskString(""))  == ""
     * Utils.maskString(" ")) == " "
     * Utils.maskString(null))  == null
     * Utils.maskString("ab"))  == "*b"
     * Utils.maskString("abbbbc")) == "***bbc"
     * Utils.maskString("abc"))  == "*bc"
     * Utils.maskString("abcbcbc"))  == "***bcbc"
     * </pre>
     *
     * @param data : data
     * @return : maskString
     */
    public static String maskString(String data) {

        if (StringUtils.isNotBlank(data) && data.length() > 1) {
            StringBuilder maskedData = new StringBuilder();
            for (int i = 0; i < data.length() / NumericConstants.TWO; i++) {
                maskedData = maskedData.append(ASTRIX);
            }
            return maskedData + StringUtils.substring(data, (data.length() / NumericConstants.TWO));
        } else if (StringUtils.isNotBlank(data) && data.length() == 1) {
            return ASTRIX;
        } else {
            return data;
        }
    }
}
