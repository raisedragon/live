package com.raise.orgs.impl.cmd;

import java.io.Serializable;

import com.raise.orgs.ActivitiIllegalArgumentException;
import com.raise.orgs.identity.ManagedResource;
import com.raise.orgs.identity.Rights;
import com.raise.orgs.impl.db.PersistentObject;
import com.raise.orgs.impl.interceptor.Command;
import com.raise.orgs.impl.interceptor.CommandContext;

public class SaveRightsCmd implements Command<Void>, Serializable {
  
  private static final long serialVersionUID = 1L;
  protected Rights rights;
  
  public SaveRightsCmd(Rights rights) {
    this.rights = rights;
  }
  
  public Void execute(CommandContext commandContext) {
    if(rights == null) {
      throw new ActivitiIllegalArgumentException("managedResource is null");
    }
	commandContext
		.getRightsManager()
		.insert((PersistentObject)rights);
	return null;
  }

}
