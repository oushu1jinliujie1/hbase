/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hbase.client;

import org.apache.yetus.audience.InterfaceAudience;

/**
 * NonceGenerator interface. In general, nonce group is an ID (one per client, or region+client, or
 * whatever) that could be used to reduce collision potential, or be used by compatible server nonce
 * manager to optimize nonce storage and removal. See HBASE-3787.
 */
@InterfaceAudience.Private
public interface NonceGenerator {

  static final String CLIENT_NONCES_ENABLED_KEY = "hbase.client.nonces.enabled";

  /** Returns the nonce group (client ID) of this client manager. */
  long getNonceGroup();

  /** Returns New nonce. */
  long newNonce();
}
