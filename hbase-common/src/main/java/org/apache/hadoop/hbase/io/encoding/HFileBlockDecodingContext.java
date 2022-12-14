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
package org.apache.hadoop.hbase.io.encoding;

import java.io.IOException;
import org.apache.hadoop.hbase.io.hfile.HFileContext;
import org.apache.hadoop.hbase.nio.ByteBuff;
import org.apache.yetus.audience.InterfaceAudience;

/**
 * A decoding context that is created by a reader's encoder, and is shared across all of the
 * reader's read operations.
 * @see HFileBlockEncodingContext for encoding
 */
@InterfaceAudience.Private
public interface HFileBlockDecodingContext {
  /**
   * Perform all actions that need to be done before the encoder's real decoding process.
   * Decompression needs to be done if {@link HFileContext#getCompression()} returns a valid
   * compression algorithm. n * numBytes after block and encoding headers n * numBytes without
   * header required to store the block after decompressing (not decoding) n * ByteBuffer pointed
   * after the header but before the data n * on disk data to be decoded
   */
  void prepareDecoding(int onDiskSizeWithoutHeader, int uncompressedSizeWithoutHeader,
    ByteBuff blockBufferWithoutHeader, ByteBuff onDiskBlock) throws IOException;

  /** Returns HFile meta information */
  HFileContext getHFileContext();
}
