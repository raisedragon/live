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
package com.raise.orgs.impl;

import com.raise.orgs.IdentityService;
import com.raise.orgs.identity.Group;
import com.raise.orgs.identity.GroupQuery;
import com.raise.orgs.identity.NativeGroupQuery;
import com.raise.orgs.identity.NativeUserQuery;
import com.raise.orgs.identity.Picture;
import com.raise.orgs.identity.User;
import com.raise.orgs.identity.UserQuery;
import com.raise.orgs.impl.cmd.CheckPassword;
import com.raise.orgs.impl.cmd.CreateGroupCmd;
import com.raise.orgs.impl.cmd.CreateGroupQueryCmd;
import com.raise.orgs.impl.cmd.CreateMembershipCmd;
import com.raise.orgs.impl.cmd.CreateUserCmd;
import com.raise.orgs.impl.cmd.CreateUserQueryCmd;
import com.raise.orgs.impl.cmd.DeleteGroupCmd;
import com.raise.orgs.impl.cmd.DeleteMembershipCmd;
import com.raise.orgs.impl.cmd.DeleteUserCmd;
import com.raise.orgs.impl.cmd.DeleteUserInfoCmd;
import com.raise.orgs.impl.cmd.GetUserInfoCmd;
import com.raise.orgs.impl.cmd.GetUserInfoKeysCmd;
import com.raise.orgs.impl.cmd.GetUserPictureCmd;
import com.raise.orgs.impl.cmd.SaveGroupCmd;
import com.raise.orgs.impl.cmd.SaveUserCmd;
import com.raise.orgs.impl.cmd.SetUserInfoCmd;
import com.raise.orgs.impl.cmd.SetUserPictureCmd;
import com.raise.orgs.impl.identity.Authentication;
import com.raise.orgs.impl.persistence.entity.GroupEntity;
import com.raise.orgs.impl.persistence.entity.IdentityInfoEntity;

import java.util.List;


/**
 * @author Tom Baeyens
 */
public class IdentityServiceImpl extends ServiceImpl implements IdentityService {
  
  public Group newGroup(String groupId) {
    return commandExecutor.execute(new CreateGroupCmd(groupId));
  }

  public User newUser(String userId) {
    return commandExecutor.execute(new CreateUserCmd(userId));
  }

  public void saveGroup(Group group) {
    commandExecutor.execute(new SaveGroupCmd((GroupEntity) group));
  }

  public void saveUser(User user) {
    commandExecutor.execute(new SaveUserCmd(user));
  }
  
  public UserQuery createUserQuery() {
    return commandExecutor.execute(new CreateUserQueryCmd());
  }

  @Override
  public NativeUserQuery createNativeUserQuery() {
    return new NativeUserQueryImpl(commandExecutor);
  }

  public GroupQuery createGroupQuery() {
    return commandExecutor.execute(new CreateGroupQueryCmd());
  }

  @Override
  public NativeGroupQuery createNativeGroupQuery() {
    return new NativeGroupQueryImpl(commandExecutor);
  }

  public void createMembership(String userId, String groupId) {
    commandExecutor.execute(new CreateMembershipCmd(userId, groupId));
  }

  public void deleteGroup(String groupId) {
    commandExecutor.execute(new DeleteGroupCmd(groupId));
  }

  public void deleteMembership(String userId, String groupId) {
    commandExecutor.execute(new DeleteMembershipCmd(userId, groupId));
  }

  public boolean checkPassword(String userId, String password) {
    return commandExecutor.execute(new CheckPassword(userId, password));
  }

  public void deleteUser(String userId) {
    commandExecutor.execute(new DeleteUserCmd(userId));
  }

  public void setUserPicture(String userId, Picture picture) {
    commandExecutor.execute(new SetUserPictureCmd(userId, picture));
  }

  public Picture getUserPicture(String userId) {
    return commandExecutor.execute(new GetUserPictureCmd(userId));
  }

  public void setAuthenticatedUserId(String authenticatedUserId) {
    Authentication.setAuthenticatedUserId(authenticatedUserId);
  }

  public String getUserInfo(String userId, String key) {
    return commandExecutor.execute(new GetUserInfoCmd(userId, key));
  }

  public List<String> getUserInfoKeys(String userId) {
    return commandExecutor.execute(new GetUserInfoKeysCmd(userId, IdentityInfoEntity.TYPE_USERINFO));
  }

  public void setUserInfo(String userId, String key, String value) {
    commandExecutor.execute(new SetUserInfoCmd(userId, key, value));
  }

  public void deleteUserInfo(String userId, String key) {
    commandExecutor.execute(new DeleteUserInfoCmd(userId, key));
  }
}
