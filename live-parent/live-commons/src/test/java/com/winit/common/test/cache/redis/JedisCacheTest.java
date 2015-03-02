package com.winit.common.test.cache.redis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.concurrent.locks.Lock;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.winit.common.orm.mybatis.cache.redis.JedisCache;

public class JedisCacheTest {

    static JedisCache cache      = null;

    static String     key_prefix = "cachekey";

    static {
    }

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        cache = new JedisCache("order");
    }

    @Before
    public void setUpBefore() throws Exception {
        cache.clear();
    }

    @Test
    public void testGetId() {
        assertEquals(cache.getId(), "order");
    }

    @Test
    public void testGetSize() {
        assertEquals(cache.getSize(), 0);
    }

    @Test
    public void testPutObject() {
        UserBean bean = new UserBean("张三", 21);
        String key = key_prefix + "1";
        cache.putObject(key, bean);
        assertEquals(cache.getSize(), 1);
        Object value = cache.getObject(key);
        assertNotNull(value);
        bean = (UserBean) value;
        assertEquals(bean.getName(), "张三");
    }

    @Test
    public void testGetObject() {
        UserBean bean = new UserBean("李四", 22);
        String key = key_prefix + "2";
        cache.putObject(key, bean);
        assertEquals(cache.getSize(), 1);
        Object value = cache.getObject(key);
        assertNotNull(value);
        bean = (UserBean) value;
        assertEquals(bean.getName(), "李四");
    }

    @Test
    public void testRemoveObject() {
        UserBean bean = new UserBean("李四", 22);
        String key = key_prefix + "2";
        cache.putObject(key, bean);
        assertEquals(cache.getSize(), 1);
        cache.removeObject(key);
        assertEquals(cache.getSize(), 0);
        Object value = cache.getObject(key);
        assertEquals(value, null);
    }

    @Test
    public void testClear() {
        cache.clear();
        assertEquals(cache.getSize(), 0);
    }

    @Test
    public void testGetReadWriteLock() {
        Lock readLock = cache.getReadWriteLock().readLock();
        assertNotNull(readLock);
        assertEquals(readLock.tryLock(), true);
        readLock.unlock();

    }

}
