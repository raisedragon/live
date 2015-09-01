package com.raise.rbac.manager;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.raise.core.manager.BaseManager;
import com.raise.rbac.dao.UserDao;
import com.raise.rbac.entity.UserEntity;

@Component
public class UserManager extends BaseManager<UserEntity, UserDao> {

    @Resource
    private UserDao userDao;

    @Override
    protected UserDao getDao() {
        return userDao;
    }

}
