package com.raise.orgs;

import static org.junit.Assert.*;

import org.activiti.engine.impl.test.TestHelper;
import org.junit.BeforeClass;
import org.junit.Test;

import com.raise.orgs.identity.ManagedResource;
import com.raise.orgs.identity.ManagedResourceType;
import com.raise.orgs.identity.Rights;
import com.raise.orgs.identity.RightsType;
import com.raise.orgs.impl.cfg.ProcessEngineConfigurationImpl;
import com.raise.orgs.impl.cmd.SaveManagedResourceCmd;
import com.raise.orgs.impl.cmd.SaveRightsCmd;
import com.raise.orgs.impl.persistence.entity.ManagedResourceEntity;
import com.raise.orgs.impl.persistence.entity.RightsEntity;

public class AuthenticateServiceTest  {
	private static ProcessEngine processEngine ;
	
	
	
	@BeforeClass
	public static void setUp(){
		String configurationResource = "activiti.cfg.xml";
		processEngine = TestHelper.getProcessEngine(configurationResource);
		assertNotNull(processEngine);
	}
	
	
	@Test
	public void testSaveRights() {
		AuthenticateService authenticateService = processEngine.getAuthenticateService();
		assertNotNull(authenticateService);
		
		Rights rights = new RightsEntity();
		rights.setGroupId("groupid");
		rights.setManagedResourceId("managedResourceId");
		rights.setType(RightsType.READ);
		
		SaveRightsCmd cmd = new SaveRightsCmd(rights);
		authenticateService.saveRights(cmd);
		
	}

	@Test
	public void testSaveManagedResource() {
		((ProcessEngineConfigurationImpl)processEngine.getProcessEngineConfiguration()).get
		AuthenticateService authenticateService = processEngine.getAuthenticateService();
		assertNotNull(authenticateService);
		
		ManagedResource resource = new ManagedResourceEntity();
		resource.setName("name");
		resource.setType(ManagedResourceType.ACTION);
		resource.setUri("/uri");
		
		SaveManagedResourceCmd cmd = new SaveManagedResourceCmd(resource);
		authenticateService.saveManagedResource(cmd);;
		
	}

}
