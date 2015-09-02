package com.raise.rbac.dao;

import com.raise.core.dao.BaseDao;
import com.raise.core.dao.MyBatisRepo;
import com.raise.rbac.entity.UserEntity;


@MyBatisRepo
public interface UserDao extends BaseDao<UserEntity> {

}
