package com.raise.orgs.impl;

import com.raise.orgs.AuthenticateService;
import com.raise.orgs.impl.cmd.SaveManagedResourceCmd;
import com.raise.orgs.impl.cmd.SaveRightsCmd;

public class AuthenticateServiceImpl  extends ServiceImpl  implements AuthenticateService {
	
	@Override
	public void saveManagedResource(SaveManagedResourceCmd cmd){
		 commandExecutor.execute(cmd);
	}
	@Override
	public void saveRights(SaveRightsCmd cmd){
		 commandExecutor.execute(cmd);
	}
}
