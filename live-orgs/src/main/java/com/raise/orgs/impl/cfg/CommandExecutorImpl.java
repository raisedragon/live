package com.raise.orgs.impl.cfg;

import com.raise.orgs.impl.interceptor.Command;
import com.raise.orgs.impl.interceptor.CommandConfig;
import com.raise.orgs.impl.interceptor.CommandExecutor;
import com.raise.orgs.impl.interceptor.CommandInterceptor;

/**
 * Command executor that passes commands to the first interceptor in the chain.
 * If no {@link CommandConfig} is passed, the default configuration will be used.  
 * 
 * @author Marcus Klimstra (CGI)
 */
public class CommandExecutorImpl implements CommandExecutor {

  private final CommandConfig defaultConfig;
  private final CommandInterceptor first;
  
  public CommandExecutorImpl(CommandConfig defaultConfig, CommandInterceptor first) {
    this.defaultConfig = defaultConfig;
    this.first = first;
  }
  
  public CommandInterceptor getFirst() {
    return first;
  }

  @Override
  public CommandConfig getDefaultConfig() {
    return defaultConfig;
  }
  
  @Override
  public <T> T execute(Command<T> command) {
    return execute(defaultConfig, command);
  }

  @Override
  public <T> T execute(CommandConfig config, Command<T> command) {
    return first.execute(config, command);
  }

}
