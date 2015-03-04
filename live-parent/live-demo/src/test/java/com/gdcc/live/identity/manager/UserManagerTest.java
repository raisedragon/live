package com.gdcc.live.identity.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.gdcc.live.identity.entity.User;
import com.gdcc.live.identity.query.UserQuery;
import com.winit.vms.system.BaseTest;

public class UserManagerTest extends BaseTest{

	@Autowired
	private UserManager userManager; 
	
	@Test
	public void testCreateUserQuery() {
		UserQuery query = userManager.createUserQuery();
		assertNotNull(query);
		List<User> users = query.list();
		
		assertNotNull(users);
		
	}


	@Test
	public void testGet() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testFind() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnable() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisable() {
		fail("Not yet implemented");
	}

	@Test
	public void testTombstoned() {
		fail("Not yet implemented");
	}

}
