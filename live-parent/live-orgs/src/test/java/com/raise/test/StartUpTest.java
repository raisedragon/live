package com.raise.test;

import java.util.UUID;

import org.activiti.engine.impl.test.TestHelper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.raise.orgs.IdentityService;
import com.raise.orgs.ProcessEngine;
import com.raise.orgs.identity.Group;
import com.raise.orgs.identity.User;

import static org.junit.Assert.*;

public class StartUpTest {
	private static ProcessEngine processEngine ;
	@BeforeClass
	public static void setUp(){
		String configurationResource = "activiti.cfg.xml";
		processEngine = TestHelper.getProcessEngine(configurationResource);
		assertNotNull(processEngine);
	}
	
	
	@Test
	public void testIdetity(){
		IdentityService identityService = processEngine.getIdentityService();
		User user = identityService.newUser(UUID.randomUUID().toString());
		user.setFirstName("First Name");
		user.setLastName("Last Name");
		user.setEmail("email@email.com");
		user.setPassword("password");
		identityService.saveUser(user);
		
		Group group = identityService.newGroup(UUID.randomUUID().toString());
		group.setName("role1");
		group.setType("role");
		
		
		identityService.saveGroup(group);
		
		identityService.createMembership(user.getId(), group.getId());;
		
		
	}
	
}
