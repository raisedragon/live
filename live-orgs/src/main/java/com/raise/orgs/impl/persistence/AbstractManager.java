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

package com.raise.orgs.impl.persistence;

import com.raise.orgs.impl.cfg.ProcessEngineConfigurationImpl;
import com.raise.orgs.impl.context.Context;
import com.raise.orgs.impl.db.DbSqlSession;
import com.raise.orgs.impl.db.PersistentObject;
import com.raise.orgs.impl.interceptor.Session;
import com.raise.orgs.impl.persistence.entity.ByteArrayEntityManager;
import com.raise.orgs.impl.persistence.entity.GroupIdentityManager;
import com.raise.orgs.impl.persistence.entity.IdentityInfoEntityManager;
import com.raise.orgs.impl.persistence.entity.MembershipIdentityManager;
import com.raise.orgs.impl.persistence.entity.ResourceEntityManager;
import com.raise.orgs.impl.persistence.entity.UserIdentityManager;
import com.raise.orgs.impl.persistence.entity.VariableInstanceEntityManager;


/**
 * @author Tom Baeyens
 * @author Joram Barrez
 */
public abstract class AbstractManager implements Session {
  
  public void insert(PersistentObject persistentObject) {
    getDbSqlSession().insert(persistentObject);
  }

  public void delete(PersistentObject persistentObject) {
    getDbSqlSession().delete(persistentObject);
  }

  protected DbSqlSession getDbSqlSession() {
    return getSession(DbSqlSession.class);
  }

  protected <T> T getSession(Class<T> sessionClass) {
    return Context.getCommandContext().getSession(sessionClass);
  }

  protected ResourceEntityManager getResourceManager() {
    return getSession(ResourceEntityManager.class);
  }
  
  protected ByteArrayEntityManager getByteArrayManager() {
    return getSession(ByteArrayEntityManager.class);
  }


  

  protected VariableInstanceEntityManager getVariableInstanceManager() {
    return getSession(VariableInstanceEntityManager.class);
  }
  
  protected UserIdentityManager getUserIdentityManager() {
    return getSession(UserIdentityManager.class);
  }
  
  protected GroupIdentityManager getGroupIdentityManager() {
    return getSession(GroupIdentityManager.class);
  }
  
  protected IdentityInfoEntityManager getIdentityInfoManager() {
    return getSession(IdentityInfoEntityManager.class);
  }
  
  protected MembershipIdentityManager getMembershipIdentityManager() {
    return getSession(MembershipIdentityManager.class);
  }
  
  protected ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
  	return Context.getProcessEngineConfiguration();
  }
  
  public void close() {
  }

  public void flush() {
  }
}
