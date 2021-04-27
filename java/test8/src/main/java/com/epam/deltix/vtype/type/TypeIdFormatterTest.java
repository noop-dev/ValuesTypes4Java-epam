/*
 * Copyright 2017-2018 Deltix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.epam.deltix.vtype.type;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TypeIdFormatterTest {

    @Test
    public void testDefaultFormatter() {

        Assert.assertEquals("I", TypeIdDefaultFormatter.makeBasicTypeDescriptor(TypeId.I32));
        Assert.assertEquals("J", TypeIdDefaultFormatter.makeBasicTypeDescriptor(TypeId.I64));
        Assert.assertEquals("F", TypeIdDefaultFormatter.makeBasicTypeDescriptor(TypeId.F32));
        Assert.assertEquals("D", TypeIdDefaultFormatter.makeBasicTypeDescriptor(TypeId.F64));
        Assert.assertEquals("V", TypeIdDefaultFormatter.makeBasicTypeDescriptor(TypeId.VOID));
        Assert.assertEquals("Ljava/lang/Object;", TypeIdDefaultFormatter.makeBasicTypeDescriptor(TypeId.OBJ_REF));

        Assert.assertEquals("I", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.I32));
        Assert.assertEquals("J", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.I64));
        Assert.assertEquals("F", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.F32));
        Assert.assertEquals("D", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.F64));
        Assert.assertEquals("V", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.VOID));
        Assert.assertEquals("Ljava/lang/Object;", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.OBJ_REF));

        Assert.assertEquals("[I", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.arrayFrom(TypeId.I32, 1)));
        Assert.assertEquals("[[J", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.arrayFrom(TypeId.I64, 2)));
        Assert.assertEquals("[[[F", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.arrayFrom(TypeId.F32, 3)));
        Assert.assertEquals("[[[[D", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.arrayFrom(TypeId.F64, 4)));
        Assert.assertEquals("[[[[[Ljava/lang/Object;", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.arrayFrom(TypeId.OBJ_REF, 5)));

        Assert.assertEquals("I", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.I32));
        Assert.assertEquals("J", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.I64));
        Assert.assertEquals("F", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.F32));
        Assert.assertEquals("D", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.F64));
        Assert.assertEquals("V", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.VOID));
        Assert.assertEquals("Ljava/lang/Object;", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.OBJ_REF));

        Assert.assertEquals("[I", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.arrayFrom(TypeId.I32, 1)));
        Assert.assertEquals("[[J", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.arrayFrom(TypeId.I64, 2)));
        Assert.assertEquals("[[[F", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.arrayFrom(TypeId.F32, 3)));
        Assert.assertEquals("[[[[D", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.arrayFrom(TypeId.F64, 4)));
        Assert.assertEquals("[[[[[Ljava/lang/Object;", TypeIdDefaultFormatter.makeSrcDescriptor(TypeId.arrayFrom(TypeId.OBJ_REF, 5)));

        Assert.assertEquals("J", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.vtValueFromIndex(13)));
        Assert.assertEquals("[J", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.arrayFrom(TypeId.vtValueFromIndex(0), 1)));
        Assert.assertEquals("[[[J", TypeIdDefaultFormatter.makeDstDescriptor(TypeId.arrayFrom(TypeId.vtValueFromIndex(10), 3)));
    }
}
