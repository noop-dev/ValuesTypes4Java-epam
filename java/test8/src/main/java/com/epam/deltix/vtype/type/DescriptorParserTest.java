/*
 * Copyright 2021 EPAM Systems, Inc
 *
 * See the NOTICE file distributed with this work for additional information
 * regarding copyright ownership. Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.epam.deltix.vtype.type;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DescriptorParserTest {
    @Test
    public void testBasicTypes() {

        assertEquals(TypeId.I32, (int) DescriptorParser.parseType("I", 0, null));
        assertEquals(TypeId.I32, (int) DescriptorParser.parseType("Z", 0, null));
        assertEquals(TypeId.OBJ_REF, (int) DescriptorParser.parseType("Lcom/epam/deltix/dt/DateTime;", 0, null));
    }

    @Test
    public void testArguments1() {
        int[] args = new int[42];
        int nParms = DescriptorParser.parseMethod(args, 0, "(Lcom/epam/deltix/dt/DateTime;)J", null);
        assertEquals(1, nParms);
        assertEquals(TypeId.I64, args[0]);
        assertEquals(TypeId.OBJ_REF, args[1]);


        nParms = DescriptorParser.parseMethod(args, 0, "(J)Lcom/epam/deltix/dt/DateTime;", null);
        assertEquals(1, nParms);
        assertEquals(TypeId.OBJ_REF, args[0]);
        assertEquals(TypeId.I64, args[1]);
    }

    @Test
    public void testVtScalar() {
        // TODO:
    }

    @Test
    public void testVtArrays() {
        // TODO:
    }
}