package com.raise.orgs.impl.cmd;

import java.io.Serializable;

import com.raise.orgs.ActivitiException;
import com.raise.orgs.ActivitiIllegalArgumentException;
import com.raise.orgs.impl.interceptor.Command;
import com.raise.orgs.impl.interceptor.CommandContext;


public class GetTableNameCmd implements Command<String>, Serializable {

  private static final long serialVersionUID = 1L;

  private Class<?> entityClass;

  public GetTableNameCmd(Class< ? > entityClass) {
    this.entityClass = entityClass;
  }

  public String execute(CommandContext commandContext) {
    if(entityClass == null) {
      throw new ActivitiIllegalArgumentException("entityClass is null");
    }
    return commandContext
      .getTableDataManager()
      .getTableName(entityClass, true);
  }

}
