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
// Generated by http://code.google.com/p/protostuff/ ... DO NOT EDIT!
// Generated from protobuf

package org.apache.drill.exec.proto.beans;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.Schema;

public final class Collector implements Externalizable, Message<Collector>, Schema<Collector>
{

    public static Schema<Collector> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static Collector getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final Collector DEFAULT_INSTANCE = new Collector();

    
    private int oppositeMajorFragmentId;
    private List<Integer> incomingMinorFragment;
    private Boolean supportsOutOfOrder;
    private Boolean isSpooling;

    public Collector()
    {
        
    }

    // getters and setters

    // oppositeMajorFragmentId

    public int getOppositeMajorFragmentId()
    {
        return oppositeMajorFragmentId;
    }

    public Collector setOppositeMajorFragmentId(int oppositeMajorFragmentId)
    {
        this.oppositeMajorFragmentId = oppositeMajorFragmentId;
        return this;
    }

    // incomingMinorFragment

    public List<Integer> getIncomingMinorFragmentList()
    {
        return incomingMinorFragment;
    }

    public Collector setIncomingMinorFragmentList(List<Integer> incomingMinorFragment)
    {
        this.incomingMinorFragment = incomingMinorFragment;
        return this;
    }

    // supportsOutOfOrder

    public Boolean getSupportsOutOfOrder()
    {
        return supportsOutOfOrder;
    }

    public Collector setSupportsOutOfOrder(Boolean supportsOutOfOrder)
    {
        this.supportsOutOfOrder = supportsOutOfOrder;
        return this;
    }

    // isSpooling

    public Boolean getIsSpooling()
    {
        return isSpooling;
    }

    public Collector setIsSpooling(Boolean isSpooling)
    {
        this.isSpooling = isSpooling;
        return this;
    }

    // java serialization

    public void readExternal(ObjectInput in) throws IOException
    {
        GraphIOUtil.mergeDelimitedFrom(in, this, this);
    }

    public void writeExternal(ObjectOutput out) throws IOException
    {
        GraphIOUtil.writeDelimitedTo(out, this, this);
    }

    // message method

    public Schema<Collector> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public Collector newMessage()
    {
        return new Collector();
    }

    public Class<Collector> typeClass()
    {
        return Collector.class;
    }

    public String messageName()
    {
        return Collector.class.getSimpleName();
    }

    public String messageFullName()
    {
        return Collector.class.getName();
    }

    public boolean isInitialized(Collector message)
    {
        return true;
    }

    public void mergeFrom(Input input, Collector message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    message.oppositeMajorFragmentId = input.readInt32();
                    break;
                case 2:
                    if(message.incomingMinorFragment == null)
                        message.incomingMinorFragment = new ArrayList<Integer>();
                    message.incomingMinorFragment.add(input.readInt32());
                    break;
                case 3:
                    message.supportsOutOfOrder = input.readBool();
                    break;
                case 4:
                    message.isSpooling = input.readBool();
                    break;
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, Collector message) throws IOException
    {
        if(message.oppositeMajorFragmentId != 0)
            output.writeInt32(1, message.oppositeMajorFragmentId, false);

        if(message.incomingMinorFragment != null)
        {
            for(Integer incomingMinorFragment : message.incomingMinorFragment)
            {
                if(incomingMinorFragment != null)
                    output.writeInt32(2, incomingMinorFragment, true);
            }
        }

        if(message.supportsOutOfOrder != null)
            output.writeBool(3, message.supportsOutOfOrder, false);

        if(message.isSpooling != null)
            output.writeBool(4, message.isSpooling, false);
    }

    public String getFieldName(int number)
    {
        switch(number)
        {
            case 1: return "oppositeMajorFragmentId";
            case 2: return "incomingMinorFragment";
            case 3: return "supportsOutOfOrder";
            case 4: return "isSpooling";
            default: return null;
        }
    }

    public int getFieldNumber(String name)
    {
        final Integer number = __fieldMap.get(name);
        return number == null ? 0 : number.intValue();
    }

    private static final java.util.HashMap<String,Integer> __fieldMap = new java.util.HashMap<String,Integer>();
    static
    {
        __fieldMap.put("oppositeMajorFragmentId", 1);
        __fieldMap.put("incomingMinorFragment", 2);
        __fieldMap.put("supportsOutOfOrder", 3);
        __fieldMap.put("isSpooling", 4);
    }
    
}
