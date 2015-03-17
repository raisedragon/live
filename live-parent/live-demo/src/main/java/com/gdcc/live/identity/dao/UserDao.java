package com.gdcc.live.identity.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.query.Page;
import com.gdcc.live.identity.entity.User;
import com.gdcc.live.identity.query.UserQuery;
import com.gdcc.live.identity.query.UserUpdate;
import com.winit.common.orm.mybatis.MyBatisRepo;

@MyBatisRepo
public interface UserDao extends Dao<User, String> {
	
	  List<User> selectByCriteria(UserQuery criteria);
	  
	  long selectCountByCriteria(UserQuery criteria);
	  
	  long updateByCriteria(UserUpdate criteria);
}
