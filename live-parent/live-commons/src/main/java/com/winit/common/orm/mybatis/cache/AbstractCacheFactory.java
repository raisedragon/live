package com.winit.common.orm.mybatis.cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.apache.ibatis.cache.Cache;

/**
 * @author jianke.zhang 2015-1-15 下午4:22:13
 * @since 1.0
 */
public abstract class AbstractCacheFactory implements CacheFactory {

    private final ConcurrentMap<String, Cache> caches = new ConcurrentHashMap<String, Cache>();

    @Override
    public Cache getCache(String id) {

        Cache cache = caches.get(id);
        if (cache == null) {
            synchronized (this) {
                cache = caches.get(id);
                if (cache == null) {
                    caches.put(id, createCache(id));
                    cache = caches.get(id);
                }
            }
        }

        return cache;
    }

    /**
     * 构建缓存对象
     * 
     * @param id
     * @return
     */
    protected abstract Cache createCache(String id);

}
