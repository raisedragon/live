package com.raise.orgs.manager;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import com.raise.orgs.dao.ConfigDao;
import com.raise.orgs.entity.ConfigEntity;
import com.raise.orgs.manager.ConfigManager;
import com.raise.test.BaseTest;

import static org.mockito.Mockito.*;

public class ConfigManagerTest extends BaseTest {

	@InjectMocks
	@Autowired
	private ConfigManager manager;

	@Mock
	private ConfigDao dao;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetDao() {
		String id = "0";
		ConfigEntity config = new ConfigEntity();
		when(dao.get(id)).thenReturn(config);
		
		verify(dao,times(0)).get(id);
		assertEquals(manager.get(id), config);
		
	}

	@Test
	public void testGet() {
		String id = "0";
		ConfigEntity config = new ConfigEntity();
		when(dao.get(id)).thenReturn(config);
		assertEquals(manager.get(id), config);
		verify(dao,times(1)).get(id);
	}

	@Test
	public void testSave() {
		ConfigEntity config = new ConfigEntity();
		doNothing().when(dao).add(config);
		manager.save(config);
		verify(dao,times(1)).add(config);
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testDisable() {
		fail("Not yet implemented");
	}

	@Test
	public void testEnable() {
		fail("Not yet implemented");
	}

}
