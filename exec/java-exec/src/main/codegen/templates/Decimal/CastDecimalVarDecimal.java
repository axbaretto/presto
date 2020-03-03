/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
<@pp.dropOutputFile />

<#list cast.types as type>
<#if type.major == "DecimalToVarDecimal">

<@pp.changeOutputFile name="/org/apache/drill/exec/expr/fn/impl/gcast/Cast${type.from}${type.to}.java" />

<#include "/@includes/license.ftl" />

package org.apache.drill.exec.expr.fn.impl.gcast;

<#include "/@includes/vv_imports.ftl" />

import org.apache.drill.exec.expr.DrillSimpleFunc;
import org.apache.drill.exec.expr.annotations.FunctionTemplate;
import org.apache.drill.exec.expr.annotations.FunctionTemplate.NullHandling;
import org.apache.drill.exec.expr.annotations.Output;
import org.apache.drill.exec.expr.annotations.Param;
import org.apache.drill.exec.expr.holders.*;
import org.apache.drill.exec.record.RecordBatch;
import org.apache.drill.exec.expr.annotations.Workspace;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.DrillBuf;

import java.nio.ByteBuffer;

/*
 * This class is generated using freemarker and the ${.template_name} template.
 */
@SuppressWarnings("unused")
@FunctionTemplate(name = "cast${type.to?upper_case}",
                  scope = FunctionTemplate.FunctionScope.SIMPLE,
                  returnType = FunctionTemplate.ReturnType.DECIMAL_CAST,
                  nulls = NullHandling.NULL_IF_NULL)
public class Cast${type.from}${type.to} implements DrillSimpleFunc {

  @Param ${type.from}Holder in;
  @Inject DrillBuf buffer;
  @Param IntHolder precision;
  @Param IntHolder scale;
  @Output ${type.to}Holder out;

  public void setup() {
  }

  public void eval() {
    java.math.BigDecimal bd =
        <#if type.from == "Decimal9" || type.from == "Decimal18">
        java.math.BigDecimal.valueOf(in.value);
        <#else>
        org.apache.drill.exec.util.DecimalUtility
          <#if type.from.contains("Sparse")>
            .getBigDecimalFromDrillBuf(in.buffer, in.start, in.nDecimalDigits, in.scale, true);
          <#elseif type.from == "VarDecimal">
            .getBigDecimalFromDrillBuf(in.buffer, in.start, in.end - in.start, in.scale);
          </#if>
        </#if>

    org.apache.drill.exec.util.DecimalUtility.checkValueOverflow(bd, precision.value, scale.value);

    bd = bd.setScale(scale.value, java.math.RoundingMode.HALF_UP);

    out.scale = scale.value;
    out.precision = precision.value;
    out.start = 0;
    byte[] bytes = bd.unscaledValue().toByteArray();
    int len = bytes.length;
    out.buffer = buffer.reallocIfNeeded(len);
    out.buffer.setBytes(out.start, bytes);
    out.end = out.start + len;
  }
}
</#if>
</#list>
