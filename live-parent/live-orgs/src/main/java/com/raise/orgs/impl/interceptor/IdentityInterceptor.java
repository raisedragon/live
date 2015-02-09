
package com.raise.orgs.impl.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.raise.orgs.impl.cfg.ProcessEngineConfigurationImpl;
import com.raise.orgs.impl.context.Context;

public class IdentityInterceptor extends AbstractCommandInterceptor {
  private static final Logger log = LoggerFactory.getLogger(IdentityInterceptor.class);

  protected CommandContextFactory commandContextFactory;
  protected ProcessEngineConfigurationImpl processEngineConfiguration;

  public IdentityInterceptor() {
  }

  public IdentityInterceptor(CommandContextFactory commandContextFactory, ProcessEngineConfigurationImpl processEngineConfiguration) {
    this.commandContextFactory = commandContextFactory;
    this.processEngineConfiguration = processEngineConfiguration;
  }

  public <T> T execute(CommandConfig config, Command<T> command) {
    CommandContext context = Context.getCommandContext();
    
    boolean contextReused = false;
    // We need to check the exception, because the transaction can be in a rollback state,
    // and some other command is being fired to compensate (eg. decrementing job retries)
    if (!config.isContextReusePossible() || context == null || context.getException() != null) { 
    	context = commandContextFactory.createCommandContext(command);    	
    }  
    else {
    	log.debug("Valid context found. Reusing it for the current command '{}'", command.getClass().getCanonicalName());
    	contextReused = true;
    }

    try {
      // Push on stack
      Context.setCommandContext(context);
      Context.setProcessEngineConfiguration(processEngineConfiguration);
      
      return next.execute(config, command);
      
    } catch (Exception e) {
    	
      context.exception(e);
      
    } finally {
      try {
    	  if (!contextReused) {
    		  context.close();
    	  }
      } finally {
    	  // Pop from stack
    	  Context.removeCommandContext();
    	  Context.removeProcessEngineConfiguration();
      }
    }
    
    return null;
  }
  
  public CommandContextFactory getCommandContextFactory() {
    return commandContextFactory;
  }
  
  public void setCommandContextFactory(CommandContextFactory commandContextFactory) {
    this.commandContextFactory = commandContextFactory;
  }

  public ProcessEngineConfigurationImpl getProcessEngineConfiguration() {
    return processEngineConfiguration;
  }

  public void setProcessEngineContext(ProcessEngineConfigurationImpl processEngineContext) {
    this.processEngineConfiguration = processEngineContext;
  }
}
