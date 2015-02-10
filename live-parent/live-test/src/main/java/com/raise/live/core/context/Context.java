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

package com.raise.live.core.context;

import java.util.Stack;

import com.raise.live.acc.entity.User;
import com.raise.live.core.cfg.LiveConfiguration;
import com.raise.live.core.command.context.CommandContext;



public class Context {

  protected static ThreadLocal<Stack<CommandContext>> commandContextThreadLocal = new ThreadLocal<Stack<CommandContext>>();
  protected static ThreadLocal<Stack<LiveConfiguration>> configurationStackThreadLocal = new ThreadLocal<Stack<LiveConfiguration>>();

  protected static ThreadLocal<User> userThreadLocal = new ThreadLocal<User>();
  
  public static CommandContext getCommandContext() {
    Stack<CommandContext> stack = getStack(commandContextThreadLocal);
    if (stack.isEmpty()) {
      return null;
    }
    return stack.peek();
  }

  public static void setCommandContext(CommandContext commandContext) {
    getStack(commandContextThreadLocal).push(commandContext);
  }

  public static void removeCommandContext() {
    getStack(commandContextThreadLocal).pop();
  }

  public static LiveConfiguration getConfiguration() {
    Stack<LiveConfiguration> stack = getStack(configurationStackThreadLocal);
    if (stack.isEmpty()) {
      return null;
    }
    return stack.peek();
  }

  public static void setConfiguration(LiveConfiguration processEngineConfiguration) {
    getStack(configurationStackThreadLocal).push(processEngineConfiguration);
  }

  public static void removeConfiguration() {
    getStack(configurationStackThreadLocal).pop();
  }



  protected static <T> Stack<T> getStack(ThreadLocal<Stack<T>> threadLocal) {
    Stack<T> stack = threadLocal.get();
    if (stack==null) {
      stack = new Stack<T>();
      threadLocal.set(stack);
    }
    return stack;
  }
  
  
  public static void setUser(User user){
	  userThreadLocal.set(user);
  }
  
  public static User getUser(){
	  return userThreadLocal.get();
  }
  
  public static void removeUser(User user){
	  userThreadLocal.remove();
  }
}
