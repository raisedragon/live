package com.gdcc.live.core.utils;

import java.io.File;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


/**
 * @author longsheng.wang
 */
@Component
public class AppUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;


    public void setApplicationContext(ApplicationContext contex) throws BeansException {
        AppUtil.applicationContext = contex;
    }

    /**
     * 获取spring的上下文。
     * 
     * @return
     */
    public static ApplicationContext getContext() {
        return applicationContext;
    }

    /**
     * 根据类从spring上下文获取bean。
     * 
     * @param cls
     * @return
     */
    public static <T> T getBean(Class<T> cls) {
    	
        T bean = applicationContext.getBean(cls);
        if(bean==null){
        	throw new RuntimeException("Bean of class " + cls.getName() +" not found");
        }
        return bean;
    }

    /**
     * 根据类名从spring上下文获取bean。
     * 
     * @param cls
     * @return
     */
    public static Object getBean(String beanId) {
        return applicationContext.getBean(beanId);
    }



    /**
     * 获取Classpath物理路径
     * 
     * @return
     */
    public static String getClasspath() {
        String classPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String rootPath = "";
        // windows下
        if ("\\".equals(File.separator)) {
            rootPath = classPath.substring(1);
            rootPath = rootPath.replace("/", "\\");
        }
        // linux下
        if ("/".equals(File.separator)) {
            rootPath = classPath.substring(1);
            rootPath = rootPath.replace("\\", "/");
        }
        return rootPath;
    }

}
