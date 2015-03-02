package com.winit.common.utils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.winit.common.test.cache.redis.UserBean;

public class SerializeUtilTest {

    @Test
    public void testSerialize() {
        UserBean bean = new UserBean("张三", 22);
        byte[] bytes = SerializeUtil.serialize(bean);
        assertNotNull(bytes);
        bean = (UserBean) SerializeUtil.unserialize(bytes);
        assertNotNull(bean);
        assertEquals(bean.getAge(), 22);

        String key = "getOrder";
        bytes = SerializeUtil.serialize(key);
        assertNotNull(bytes);
        String val = (String) SerializeUtil.unserialize(bytes);
        assertEquals(val, key);

        Integer count = Integer.valueOf(10);
        bytes = SerializeUtil.serialize(count);
        assertNotNull(bytes);
        Integer reCount = (Integer) SerializeUtil.unserialize(bytes);
        assertEquals(reCount, count);
    }

}
