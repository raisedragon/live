package com.gdcc.live.identity.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.query.Page;
import com.gdcc.live.identity.entity.User;
import com.gdcc.live.identity.query.UserSelectQuery;
import com.gdcc.live.identity.query.UserUpdateQuery;
import com.winit.common.orm.mybatis.MyBatisRepo;

@MyBatisRepo
public interface UserDao extends Dao<User, String> {
	
	  List<User> selectByCriteria(UserSelectQuery criteria);
	  
	  long selectCountByCriteria(UserSelectQuery criteria);
	  
	  long updateByCriteria(UserUpdateQuery criteria);
}
