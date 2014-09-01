package com.raise.test;

import org.activiti.engine.impl.test.TestHelper;
import org.junit.Test;

import com.raise.orgs.IdentityService;
import com.raise.orgs.ProcessEngine;

import static org.junit.Assert.*;

public class StartUpTest {
	@Test
	public void testStartUp(){
		String configurationResource = "activiti.cfg.xml";
		ProcessEngine processEngine = TestHelper.getProcessEngine(configurationResource);
		assertNotNull(processEngine);
		IdentityService identityService = processEngine.getIdentityService();
		assertNotNull(identityService);
	}
}
