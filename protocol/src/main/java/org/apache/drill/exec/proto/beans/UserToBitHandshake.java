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

import com.dyuproject.protostuff.GraphIOUtil;
import com.dyuproject.protostuff.Input;
import com.dyuproject.protostuff.Message;
import com.dyuproject.protostuff.Output;
import com.dyuproject.protostuff.Schema;

public final class UserToBitHandshake implements Externalizable, Message<UserToBitHandshake>, Schema<UserToBitHandshake>
{

    public static Schema<UserToBitHandshake> getSchema()
    {
        return DEFAULT_INSTANCE;
    }

    public static UserToBitHandshake getDefaultInstance()
    {
        return DEFAULT_INSTANCE;
    }

    static final UserToBitHandshake DEFAULT_INSTANCE = new UserToBitHandshake();

    static final Boolean DEFAULT_SUPPORT_COMPLEX_TYPES = new Boolean(false);
    static final Boolean DEFAULT_SUPPORT_TIMEOUT = new Boolean(false);
    
    private RpcChannel channel;
    private Boolean supportListening;
    private int rpcVersion;
    private UserCredentials credentials;
    private UserProperties properties;
    private Boolean supportComplexTypes = DEFAULT_SUPPORT_COMPLEX_TYPES;
    private Boolean supportTimeout = DEFAULT_SUPPORT_TIMEOUT;
    private RpcEndpointInfos clientInfos;
    private SaslSupport saslSupport;

    public UserToBitHandshake()
    {
        
    }

    // getters and setters

    // channel

    public RpcChannel getChannel()
    {
        return channel == null ? RpcChannel.USER : channel;
    }

    public UserToBitHandshake setChannel(RpcChannel channel)
    {
        this.channel = channel;
        return this;
    }

    // supportListening

    public Boolean getSupportListening()
    {
        return supportListening;
    }

    public UserToBitHandshake setSupportListening(Boolean supportListening)
    {
        this.supportListening = supportListening;
        return this;
    }

    // rpcVersion

    public int getRpcVersion()
    {
        return rpcVersion;
    }

    public UserToBitHandshake setRpcVersion(int rpcVersion)
    {
        this.rpcVersion = rpcVersion;
        return this;
    }

    // credentials

    public UserCredentials getCredentials()
    {
        return credentials;
    }

    public UserToBitHandshake setCredentials(UserCredentials credentials)
    {
        this.credentials = credentials;
        return this;
    }

    // properties

    public UserProperties getProperties()
    {
        return properties;
    }

    public UserToBitHandshake setProperties(UserProperties properties)
    {
        this.properties = properties;
        return this;
    }

    // supportComplexTypes

    public Boolean getSupportComplexTypes()
    {
        return supportComplexTypes;
    }

    public UserToBitHandshake setSupportComplexTypes(Boolean supportComplexTypes)
    {
        this.supportComplexTypes = supportComplexTypes;
        return this;
    }

    // supportTimeout

    public Boolean getSupportTimeout()
    {
        return supportTimeout;
    }

    public UserToBitHandshake setSupportTimeout(Boolean supportTimeout)
    {
        this.supportTimeout = supportTimeout;
        return this;
    }

    // clientInfos

    public RpcEndpointInfos getClientInfos()
    {
        return clientInfos;
    }

    public UserToBitHandshake setClientInfos(RpcEndpointInfos clientInfos)
    {
        this.clientInfos = clientInfos;
        return this;
    }

    // saslSupport

    public SaslSupport getSaslSupport()
    {
        return saslSupport == null ? SaslSupport.UNKNOWN_SASL_SUPPORT : saslSupport;
    }

    public UserToBitHandshake setSaslSupport(SaslSupport saslSupport)
    {
        this.saslSupport = saslSupport;
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

    public Schema<UserToBitHandshake> cachedSchema()
    {
        return DEFAULT_INSTANCE;
    }

    // schema methods

    public UserToBitHandshake newMessage()
    {
        return new UserToBitHandshake();
    }

    public Class<UserToBitHandshake> typeClass()
    {
        return UserToBitHandshake.class;
    }

    public String messageName()
    {
        return UserToBitHandshake.class.getSimpleName();
    }

    public String messageFullName()
    {
        return UserToBitHandshake.class.getName();
    }

    public boolean isInitialized(UserToBitHandshake message)
    {
        return true;
    }

    public void mergeFrom(Input input, UserToBitHandshake message) throws IOException
    {
        for(int number = input.readFieldNumber(this);; number = input.readFieldNumber(this))
        {
            switch(number)
            {
                case 0:
                    return;
                case 1:
                    message.channel = RpcChannel.valueOf(input.readEnum());
                    break;
                case 2:
                    message.supportListening = input.readBool();
                    break;
                case 3:
                    message.rpcVersion = input.readInt32();
                    break;
                case 4:
                    message.credentials = input.mergeObject(message.credentials, UserCredentials.getSchema());
                    break;

                case 5:
                    message.properties = input.mergeObject(message.properties, UserProperties.getSchema());
                    break;

                case 6:
                    message.supportComplexTypes = input.readBool();
                    break;
                case 7:
                    message.supportTimeout = input.readBool();
                    break;
                case 8:
                    message.clientInfos = input.mergeObject(message.clientInfos, RpcEndpointInfos.getSchema());
                    break;

                case 9:
                    message.saslSupport = SaslSupport.valueOf(input.readEnum());
                    break;
                default:
                    input.handleUnknownField(number, this);
            }   
        }
    }


    public void writeTo(Output output, UserToBitHandshake message) throws IOException
    {
        if(message.channel != null)
             output.writeEnum(1, message.channel.number, false);

        if(message.supportListening != null)
            output.writeBool(2, message.supportListening, false);

        if(message.rpcVersion != 0)
            output.writeInt32(3, message.rpcVersion, false);

        if(message.credentials != null)
             output.writeObject(4, message.credentials, UserCredentials.getSchema(), false);


        if(message.properties != null)
             output.writeObject(5, message.properties, UserProperties.getSchema(), false);


        if(message.supportComplexTypes != null && message.supportComplexTypes != DEFAULT_SUPPORT_COMPLEX_TYPES)
            output.writeBool(6, message.supportComplexTypes, false);

        if(message.supportTimeout != null && message.supportTimeout != DEFAULT_SUPPORT_TIMEOUT)
            output.writeBool(7, message.supportTimeout, false);

        if(message.clientInfos != null)
             output.writeObject(8, message.clientInfos, RpcEndpointInfos.getSchema(), false);


        if(message.saslSupport != null)
             output.writeEnum(9, message.saslSupport.number, false);
    }

    public String getFieldName(int number)
    {
        switch(number)
        {
            case 1: return "channel";
            case 2: return "supportListening";
            case 3: return "rpcVersion";
            case 4: return "credentials";
            case 5: return "properties";
            case 6: return "supportComplexTypes";
            case 7: return "supportTimeout";
            case 8: return "clientInfos";
            case 9: return "saslSupport";
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
        __fieldMap.put("channel", 1);
        __fieldMap.put("supportListening", 2);
        __fieldMap.put("rpcVersion", 3);
        __fieldMap.put("credentials", 4);
        __fieldMap.put("properties", 5);
        __fieldMap.put("supportComplexTypes", 6);
        __fieldMap.put("supportTimeout", 7);
        __fieldMap.put("clientInfos", 8);
        __fieldMap.put("saslSupport", 9);
    }
    
}
