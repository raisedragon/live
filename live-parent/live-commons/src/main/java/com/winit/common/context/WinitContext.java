package com.winit.common.context;

import java.io.Serializable;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

import com.google.common.collect.Maps;

/**
 * context上下文对象，spi中commandText需继承
 * 
 * @version Revision History
 * 
 * <pre>
 * Author     Version       Date        Changes
 * fu.wan    1.0           2014-10-21     Created
 *
 * </pre>
 * @since 1.
 */
public class WinitContext implements Serializable {

    private static final long   serialVersionUID = 3171398407149447237L;

    public static final String LOCALE = "com.winit.context.locale";
    public static final String USER_NAME = "com.winit.context.user_name";
    public static final String USER_ID = "com.winit.context.user_id";
    public static final String ORG_ID = "com.winit.context.org_id";
    public static final String TIMEZONE = "com.winit.context.timezone";
    public static final String SEQUENCE = "com.winit.context.sequence";

    private Map<String, Object> attributes;

    public WinitContext(){
        this.attributes = Maps.newHashMap();
    }
    
    public void setUserId(String userId){
    	set(USER_ID, userId);
    }
    
    public String getUserId(){
    	return get(WinitContext.USER_ID);
    }
    
    /**
     * 设置当前命令Locale
     *
     * @param locale 当前命令Locale
     */
    public void setLocale(Locale locale) {
        set(LOCALE, locale);
    }

    /**
     * 获取当前命令的Locale.若没有指定则使用{@link java.util.Locale#getDefault() default
     * locale}.
     *
     * @return 当前命令的Locale
     */
    public Locale getLocale() {
        Locale locale = (Locale) get(WinitContext.LOCALE);

        if (locale == null) {
            locale = Locale.getDefault();
            setLocale(locale);
        }

        return locale;
    }
    
    /***
     * 或者语言国家编码 比如  en_US zh_TW zh_CN
     * TODO Add comments here.
     * @return
     */
    public String getLanguageCountry(){
    	   Locale locale = this.getLocale();
    	   return locale.getLanguage()+"_"+locale.getCountry();
    }

    public TimeZone getTimeZone() {
        return get(WinitContext.TIMEZONE);
    }

    public void setTimeZone(TimeZone timezone) {
        set(WinitContext.TIMEZONE, timezone);
    }

    public String getSequence() {
        return get(WinitContext.SEQUENCE);
    }

    public void setSequence(String sequence) {
        set(WinitContext.SEQUENCE, sequence);
    }

    public String getUsername() {
        return get(WinitContext.USER_NAME);
    }

    public void setUsername(String username) {
        set(WinitContext.USER_NAME, username);
    }

    public Long getOrgId() {
        return get(WinitContext.ORG_ID);
    }

    public void setOrgId(Long orgId) {
        set(WinitContext.ORG_ID, orgId);
    }

    public <T> T get(String key) {
        return (T) attributes.get(key);
    }

    public void set(String key, Object value) {
        attributes.put(key, value);
    }

    public void clean(){
        this.attributes.clear();
    }
}
