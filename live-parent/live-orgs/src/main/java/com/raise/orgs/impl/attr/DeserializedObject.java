/* Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.raise.orgs.impl.attr;

import java.util.Arrays;

import com.raise.orgs.impl.persistence.entity.AttributeInstanceEntity;


/**
 * @author Tom Baeyens
 */
public class DeserializedObject {

  Object deserializedObject;
  byte[] originalBytes;
  AttributeInstanceEntity variableInstanceEntity;
  
  public DeserializedObject(Object deserializedObject, byte[] serializedBytes, AttributeInstanceEntity variableInstanceEntity) {
    this.deserializedObject = deserializedObject;
    this.originalBytes = serializedBytes;
    this.variableInstanceEntity = variableInstanceEntity;
  }

  public void flush() {
    // this first check verifies if the variable value was not overwritten with another object
    if (deserializedObject==variableInstanceEntity.getCachedValue() && !variableInstanceEntity.isDeleted()) {
      byte[] bytes = SerializableType.serialize(deserializedObject, variableInstanceEntity);
      if (!Arrays.equals(originalBytes, bytes)) {
        variableInstanceEntity.setBytes(bytes);
      }
    }
  }
}