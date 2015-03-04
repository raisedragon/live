package com.gdcc.live.core.cache;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Adempiere Cache Management
 * 
 * @author longsheng.wang
 */
public class CacheManager {

    /**
     * Get Cache Management
     * 
     * @return Cache Manager
     */
    public static synchronized CacheManager get() {
        if (s_cache == null) s_cache = new CacheManager();
        return s_cache;
    } // get

    /** Singleton */
    private static CacheManager s_cache = null;

    /**
     * Private Constructor
     */
    private CacheManager(){
    } // CacheMgt

    /** List of Instances */
    private ArrayList<CacheInterface> m_instances  = new ArrayList<CacheInterface>();
    /** List of Table Names */
    private ArrayList<String>         m_tableNames = new ArrayList<String>();
    /** Logger */
    private static Logger             log          = LoggerFactory.getLogger(CacheManager.class);

    /**************************************************************************
     * Register Cache Instance
     * 
     * @param instance Cache
     * @return true if added
     */
    @SuppressWarnings("rawtypes")
    public synchronized boolean register(CacheInterface instance) {
        if (instance == null) return false;
        if (instance instanceof CCache) {
            String tableName = ((CCache) instance).getName();
            m_tableNames.add(tableName);
        }
        return m_instances.add(instance);
    } // register

    /**
     * Un-Register Cache Instance
     * 
     * @param instance Cache
     * @return true if removed
     */
    public boolean unregister(CacheInterface instance) {
        if (instance == null) return false;
        boolean found = false;
        // Could be included multiple times
        for (int i = m_instances.size() - 1; i >= 0; i--) {
            CacheInterface stored = (CacheInterface) m_instances.get(i);
            if (instance.equals(stored)) {
                m_instances.remove(i);
                found = true;
            }
        }
        return found;
    } // unregister

    /**************************************************************************
     * Reset All registered Cache
     * 
     * @return number of deleted cache entries
     */
    public int reset() {
        int counter = 0;
        int total = 0;
        for (int i = 0; i < m_instances.size(); i++) {
            CacheInterface stored = (CacheInterface) m_instances.get(i);
            if (stored != null && stored.size() > 0) {
                log.info(stored.toString());
                total += stored.reset();
                counter++;
            }
        }
        log.info("#" + counter + " (" + total + ")");
        return total;
    } // reset

    /**
     * Total Cached Elements
     * 
     * @return count
     */
    @SuppressWarnings("rawtypes")
    public int getElementCount() {
        int total = 0;
        for (int i = 0; i < m_instances.size(); i++) {
            CacheInterface stored = (CacheInterface) m_instances.get(i);
            if (stored != null && stored.size() > 0) {
                log.info(stored.toString());
                if (stored instanceof CCache) total += ((CCache) stored).sizeNoExpire();
                else total += stored.size();
            }
        }
        return total;
    } // getElementCount

    /**
     * String Representation
     * 
     * @return info
     */
    public String toString() {
        StringBuffer sb = new StringBuffer("CacheMgt[");
        sb.append("Instances=").append(m_instances.size()).append("]");
        return sb.toString();
    } // toString

    /**
     * Extended String Representation
     * 
     * @return info
     */
    public String toStringX() {
        StringBuffer sb = new StringBuffer("CacheMgt[");
        sb.append("Instances=").append(m_instances.size()).append(", Elements=").append(getElementCount()).append("]");
        return sb.toString();
    } // toString

} // CCache
