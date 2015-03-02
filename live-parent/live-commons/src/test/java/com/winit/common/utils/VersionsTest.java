package com.winit.common.utils;

import com.winit.common.spring.SpringContextHolder;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

/**
 * Created by liuye on 2015/2/3.
 */
public class VersionsTest {
    @Test
    public void testGetVersion(){
        String defaultVersion="1.0.0";
        Assert.assertEquals(Versions.getVersion(this.getClass(),defaultVersion),defaultVersion);
        Assert.assertNotEquals(Versions.getVersion(ApplicationContext.class, defaultVersion), defaultVersion);
    }


}
