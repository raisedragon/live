package com.raise.orgs.impl;

import com.raise.orgs.identity.NativeUserQuery;
import com.raise.orgs.identity.User;
import com.raise.orgs.impl.interceptor.CommandContext;
import com.raise.orgs.impl.interceptor.CommandExecutor;

import java.util.List;
import java.util.Map;

public class NativeUserQueryImpl extends AbstractNativeQuery<NativeUserQuery, User> implements NativeUserQuery {

  private static final long serialVersionUID = 1L;
  
  public NativeUserQueryImpl(CommandContext commandContext) {
    super(commandContext);
  }

  public NativeUserQueryImpl(CommandExecutor commandExecutor) {
    super(commandExecutor);
  }


 //results ////////////////////////////////////////////////////////////////
  
  public List<User> executeList(CommandContext commandContext, Map<String, Object> parameterMap, int firstResult, int maxResults) {
    return commandContext
      .getUserIdentityManager()
      .findUsersByNativeQuery(parameterMap, firstResult, maxResults);
  }
  
  public long executeCount(CommandContext commandContext, Map<String, Object> parameterMap) {
    return commandContext
      .getUserIdentityManager()
      .findUserCountByNativeQuery(parameterMap);
  }

}