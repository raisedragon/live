package com.winit.common.spring;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.MessageSource;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import java.util.Locale;

/**
 * Created by liuye on 2015/1/16.
 */
@DirtiesContext
@ContextConfiguration(locations = { "/i18n/message-context.xml" })
public class SpringMessageLocatorTest extends AbstractJUnit4SpringContextTests {

    @Test
    public void testMessageSource(){
        MessageSource messageSource = (MessageSource) applicationContext.getBean("messageSource");
        Assert.assertEquals("China",messageSource.getMessage("country.china",null,Locale.US));
        Assert.assertEquals("中国",messageSource.getMessage("country.china",null, Locale.CHINA));
        Assert.assertEquals("American", messageSource.getMessage("country.american",null,Locale.US));
        Assert.assertEquals("美国",messageSource.getMessage("country.american",null, Locale.CHINA));
    }
    @Test
    public void testMessageLocator(){
        SpringMessageLocator springMessageLocator = (SpringMessageLocator) applicationContext.getBean("springMessageLocator");
        Assert.assertEquals("China",springMessageLocator.getMessage("country.china",Locale.US));
        Assert.assertEquals("中国",springMessageLocator.getMessage("country.china", Locale.CHINA));
        Assert.assertEquals("American", springMessageLocator.getMessage("country.american",Locale.US));
        Assert.assertEquals("美国",springMessageLocator.getMessage("country.american", Locale.CHINA));
    }
}
