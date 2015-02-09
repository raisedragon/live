package com.raise.orgs.core.spring;

import java.io.File;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author longsheng.wang
 */
public class AppUtil implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    private static ServletContext     servletContext;

    /**
     * @param servletContext
     */
    public static void init(ServletContext ctx) {
        servletContext = ctx;
    }

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
     * 获取web应用的ServletContext对象。
     * 
     * @return
     * @throws Exception
     */
    public static ServletContext getServletContext() throws Exception {
        return servletContext;
    }

    /**
     * 根据类从spring上下文获取bean。
     * @param <T>
     * 
     * @param cls
     * @return
     */
    public static <T> T getBean(Class<T> cls) {
        return applicationContext.getBean(cls);
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
     * 取得应用程序的绝对路径
     * 
     * @return
     */
    public static String getAppAbsolutePath() {
        return servletContext.getRealPath("/");
    }

    /**
     * 在web环境中根据web页面的路径获取对应页面的绝对路径。
     * 
     * @param path
     * @return
     */
    public static String getRealPath(String path) {
        return servletContext.getRealPath(path);
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
