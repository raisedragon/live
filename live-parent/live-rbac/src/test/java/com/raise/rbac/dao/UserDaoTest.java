package com.raise.rbac.dao;

import static org.junit.Assert.fail;

import javax.annotation.Resource;

import org.junit.Test;

import com.raise.core.test.BaseTest;
import com.raise.rbac.query.UserQuery;

public class UserDaoTest extends BaseTest {

    @Resource
    private UserDao userDao;
    @Test
    public void testGet() {
        fail("Not yet implemented");
    }

    @Test
    public void testAdd() {
        fail("Not yet implemented");
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

    @Test
    public void getByCriteria() {
        UserQuery query = new UserQuery();
        query.withNameLike("raise");
        userDao.getByCriteria(query);
    }

    @Test
    public void countByCriteria() {
        fail("Not yet implemented");
    }

}
