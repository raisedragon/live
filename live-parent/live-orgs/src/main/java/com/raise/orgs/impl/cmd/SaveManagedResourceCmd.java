package com.raise.orgs.impl.cmd;

import java.io.Serializable;

import com.raise.orgs.ActivitiIllegalArgumentException;
import com.raise.orgs.identity.ManagedResource;
import com.raise.orgs.impl.db.PersistentObject;
import com.raise.orgs.impl.interceptor.Command;
import com.raise.orgs.impl.interceptor.CommandContext;

public class SaveManagedResourceCmd implements Command<Void>, Serializable {
  
  private static final long serialVersionUID = 1L;
  protected ManagedResource managedResource;
  
  public SaveManagedResourceCmd(ManagedResource managedResource) {
    this.managedResource = managedResource;
  }
  
  public Void execute(CommandContext commandContext) {
    if(managedResource == null) {
      throw new ActivitiIllegalArgumentException("managedResource is null");
    }
    
    	commandContext
    		.getManagedResourceManager()
    		.insert((PersistentObject)managedResource);
		return null;
  }

}
