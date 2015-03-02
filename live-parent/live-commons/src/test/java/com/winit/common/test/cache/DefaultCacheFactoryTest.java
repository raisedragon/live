package com.winit.common.test.cache;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.cache.Cache;
import org.junit.Test;

import com.winit.common.orm.mybatis.cache.CacheFactory;
import com.winit.common.orm.mybatis.cache.DefaultCacheFactory;

public class DefaultCacheFactoryTest {

    @Test
    public void test() {
        CacheFactory cacheFactory = new DefaultCacheFactory();

        Cache cache = cacheFactory.getCache("test");

        assertNotNull(cache);

        assertNotNull(cache.getId());

        cache.clear();

        cache.putObject("test1", "test1");

        assertEquals(cache.getObject("test1"), "test1");

        assertEquals(cache.getSize() == 1, true);

        assertEquals(cache.removeObject("test1"), "test1");

        assertEquals(cache.getSize() == 0, true);
    }

}
