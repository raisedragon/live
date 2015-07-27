package com.gdcc.live.identity.manager.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.manager.AbstractManager;
import com.gdcc.live.core.query.Page;
import com.gdcc.live.identity.dao.UserDao;
import com.gdcc.live.identity.entity.User;
import com.gdcc.live.identity.manager.UserManager;
import com.gdcc.live.identity.query.UserSelectQuery;


@Component
public class UserManagerImpl extends AbstractManager<User,String> implements UserManager {
	
	@Autowired
	UserDao dao;
	
	@Override
	protected Dao<User, String> getDao() {
		return dao;
	}

	@Override
	public UserSelectQuery createUserQuery() {
		return new UserSelectQuery(appContext);
	}


}
