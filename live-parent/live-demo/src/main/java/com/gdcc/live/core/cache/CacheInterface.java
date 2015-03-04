package com.gdcc.live.core.cache;

/**
 * Cache Interface
 * 
 * @author longsheng.wang
 */
public interface CacheInterface {

    /**
     * Reset Cache
     * 
     * @return number of items reset
     */
    public int reset();

    /**
     * Get Size of Cache
     * 
     * @return number of items
     */
    public int size();

} // CacheInterface
