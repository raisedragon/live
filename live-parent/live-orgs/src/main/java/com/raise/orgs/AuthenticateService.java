package com.raise.orgs;

import com.raise.orgs.impl.cmd.SaveManagedResourceCmd;
import com.raise.orgs.impl.cmd.SaveRightsCmd;

public interface AuthenticateService {

	void saveManagedResource(SaveManagedResourceCmd cmd);

	void saveRights(SaveRightsCmd cmd);
	
}
