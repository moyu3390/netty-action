/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.wuhulala.rpc.serialzation;

import com.alibaba.cooma.Extension;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Serialization strategy interface that specifies a serializer. (SPI, Singleton, ThreadSafe)
 *
 * The default extension is hessian2 and the default serialization implementation of the dubbo protocol.
 * <pre>
 *     e.g. &lt;dubbo:protocol serialization="xxx" /&gt;
 * </pre>
 */
@Extension
public interface Serialization {

    /**
     * Get content type unique id, recommended that custom implementations use values greater than 20.
     *
     * @return content type id
     */
    byte getContentTypeId();

    /**
     * Get content type
     *
     * @return content type
     */
    String getContentType();

    /**
     * Get a serialization implementation instance
     *
     * @param url URL address for the remote service
     * @param output the underlying output stream
     * @return serializer
     * @throws IOException
     */
    ObjectOutput serialize(OutputStream output) throws IOException;

    /**
     * Get a deserialization implementation instance
     *
     * @param url URL address for the remote service
     * @param input the underlying input stream
     * @return deserializer
     * @throws IOException
     */
    ObjectInput deserialize(InputStream input) throws IOException;

}