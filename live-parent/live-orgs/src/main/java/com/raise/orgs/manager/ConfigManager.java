package com.raise.orgs.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.core.manager.BaseManager;
import com.raise.orgs.dao.ConfigDao;
import com.raise.orgs.entity.ConfigEntity;


@Component
public class ConfigManager extends BaseManager<ConfigEntity, ConfigDao>{
	@Autowired
	ConfigDao dao;

	@Override
	protected ConfigDao getDao() {
		return dao;
	}

}
