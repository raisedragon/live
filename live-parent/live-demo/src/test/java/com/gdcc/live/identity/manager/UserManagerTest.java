package com.gdcc.live.identity.manager;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.gdcc.live.identity.dao.UserDao;
import com.gdcc.live.identity.entity.User;
import com.gdcc.live.identity.query.UserSelectQuery;
import com.gdcc.live.test.BaseTest;

public class UserManagerTest extends BaseTest{

	@Autowired
	private UserManager userManager; 
	
	@Autowired(required = true)
	UserDao dao;
	
	@Test
	public void testCreateUserQuery() {
		UserSelectQuery query = userManager.createUserQuery();
		assertNotNull(query);
		
		User user = query.singleResult();
		List<User> users = query.list();
		
		assertNotNull(users);
		
	}


	@Test
	public void testGet() {
		User user = new User();
		user.setId(idGenerator.getSuid());
		user.setAccount(user.getId());
		user.setBirthday(new Date());
		user.setFirstName(user.getId());
		user.setLastName(user.getId());
		user.setPassword(user.getId());
		
		userManager.add(user);
		
		User user2 = userManager.get(user.getId());
		assertNotNull(user2);
		
	}

	@Test
	@Rollback(false)
	public void testAdd() {
		User user = new User();
		user.setId(idGenerator.getSuid());
		user.setAccount(user.getId());
		user.setBirthday(new Date());
		user.setFirstName(user.getId());
		user.setLastName(user.getId());
		user.setPassword(user.getId());
		
		userManager.add(user);
		
		User user2 = userManager.get(user.getId());
		assertNotNull(user2);
		
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
