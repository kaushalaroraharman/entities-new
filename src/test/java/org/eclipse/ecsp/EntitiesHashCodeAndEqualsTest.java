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

package org.eclipse.ecsp;

import org.eclipse.ecsp.utils.PojoTestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.util.HashSet;
import java.util.Set;

/**
 * Entities hash code and equals test class.
 */
public class EntitiesHashCodeAndEqualsTest {

    @Test
    public void testAllEntitiesHashCodeEqualsContract() {
        Reflections reflections = new Reflections("org.eclipse.ecsp", new SubTypesScanner(false));
        Set<Class<?>> allClasses = new HashSet<>(reflections.getSubTypesOf(Object.class));
        allClasses.forEach(classObject -> {
            if (PojoTestUtils.validateMethodAccessors(classObject, "hashCode")) {
                try {
                    Object object1 = classObject.newInstance();
                    Object object2 = classObject.newInstance();
                    Assert.assertEquals(object1, object2);
                    Assert.assertNotNull(object1);
                    Assert.assertEquals(object1.hashCode(), object2.hashCode());
                } catch (Exception e) {
                    //Handled because some classes cant be initialised or some toString might throw nullpointers
                }
            }
        });
    }

}
