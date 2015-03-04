package com.gdcc.live.core.utils;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gdcc.live.core.cache.CCache;
import com.gdcc.live.system.entity.Config;
import com.gdcc.live.system.manager.ConfigManager;
import com.gdcc.live.system.query.ConfigQuery.FindQuery;

public class ConfigUtil {

    private static ConfigManager          configManager;

    /** Static Logger */
    private static Logger                 s_log   = LoggerFactory.getLogger(ConfigUtil.class);
    /** Cache */
    private static CCache<String, String> s_cache = new CCache<String, String>(Config.class.getName(), 500, 1);

    /**
     * Reset Cache
     */
    public static void resetCache() {
        s_cache.reset();
    }

    /**
     * Get system configuration property of type string
     * 
     * @param name
     * @return String
     */
    public static String getValue(String name) {
        return getValue(name, null);
    }

    /**
     * Get system configuration property of type int
     * 
     * @param name
     * @param defaultValue
     * @return int
     */
    public static int getIntValue(String name, int defaultValue) {
        String s = getValue(name);
        if (s == null) return defaultValue;

        if (s.length() == 0) return defaultValue;
        //
        try {
            return Integer.parseInt(s);
        } catch (NumberFormatException e) {
            s_log.error("getIntValue (" + name + ") = " + s, e);
        }
        return defaultValue;
    }

    /**
     * Get system configuration property of type double
     * 
     * @param name
     * @param defaultValue
     * @return double
     */
    public static double getDoubleValue(String name, double defaultValue) {
        String s = getValue(name);
        if (s == null || s.length() == 0) return defaultValue;
        //
        try {
            return Double.parseDouble(s);
        } catch (NumberFormatException e) {
            s_log.error("getDoubleValue (" + name + ") = " + s, e);
        }
        return defaultValue;
    }

    /**
     * Get system configuration property of type boolean
     * 
     * @param name
     * @param defaultValue
     * @return boolean
     */
    public static boolean getBooleanValue(String name, boolean defaultValue) {
        String s = getValue(name);
        if (s == null || s.length() == 0) return defaultValue;

        if ("Y".equalsIgnoreCase(s)) return true;
        else if ("N".equalsIgnoreCase(s)) return false;
        else return Boolean.valueOf(s).booleanValue();
    }

    private static void ensureInit() {
        if (configManager != null) {
            return;
        }
        configManager = (ConfigManager) AppUtil.getBean(ConfigManager.class);
        if (configManager == null) {
            throw new RuntimeException("ISysConfigService instance not found");
        }
    }

    /**
     * Get client configuration property of type string
     * 
     * @param Name
     * @param defaultValue
     * @param Client ID
     * @param Organization ID
     * @return String
     */
    public static String getValue(String name, String defaultValue) {
        // TODO
        ensureInit();
        String key = name;
        String str = s_cache.get(key);
        if (str != null) return str;
        if (str == null && s_cache.containsKey(key)) // found null key
        return defaultValue;

        FindQuery query = new FindQuery();
        query.createCriteria().andNameEqualTo(key).andIsActiveEqualTo(true);
        List<Config> configs = configManager.queryByCriteria(query);
        if (configs != null && configs.size() > 0) {
            str = configs.get(0).getValue();
        }

        //
        if (str != null) {
            str = str.trim();
            s_cache.put(key, str);
            return str;
        } else {
            // anyways, put the not found key as null
            s_cache.put(key, null);
            return defaultValue;
        }
    }

}
