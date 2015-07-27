package com.raise.orgs.dao;

import static org.junit.Assert.*;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import com.raise.orgs.entity.ConfigEntity;
import com.raise.test.BaseTest;

public class ConfigDaoTest extends BaseTest {

	@Autowired
	private ConfigDao dao;
	
	@Test
	public void testGet() {
		dao.get("0");
	}

	/**
	 * 测试基础方法
	 */
	@Test
	public void testBaseMethod() {
		//add
		ConfigEntity entity = new ConfigEntity();
		entity.setId(idGenerator.nextStrId());
		entity.setName(entity.getId());
		entity.setValue(entity.getId());
		entity.setActive(true);
		entity.setDeleted(false);
		entity.setOrganizationId("0");
		entity.setUpdated(new Date());
		entity.setUpdatedBy("0");
		entity.setCreated(new Date());
		entity.setCreatedBy("0");
		dao.add(entity);
		//get
		ConfigEntity entity2 = dao.get(entity.getId());
		assertEquals(ToStringBuilder.reflectionToString(entity,ToStringStyle.SIMPLE_STYLE), ToStringBuilder.reflectionToString(entity2,ToStringStyle.SIMPLE_STYLE));
		//update
		entity2.setValue("new value");
		dao.update(entity2);
		//
		
		
		
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
