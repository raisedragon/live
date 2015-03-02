package com.winit.common.orm.mybatis.cache;

import java.util.concurrent.locks.ReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.apache.ibatis.cache.CacheException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.winit.common.orm.mybatis.cache.exception.MybatisCacheException;

/**
 * 默认缓存实现类
 * 
 * @author jianke.zhang 2015-1-15 下午4:21:02
 * @since 1.0
 */
public class CacheExt implements Cache {

    private final Logger              log          = LoggerFactory.getLogger(CacheExt.class);

    private static final CacheFactory cacheFactory = new DefaultCacheFactory();

    private final Cache               cache;

    public CacheExt(String id){
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        log.info("init default cache,id:" + id);

        cache = cacheFactory.getCache(id);

        if (cache == null) {
            throw new MybatisCacheException("Create a cache failure,id:" + id);
        }
    }

    @Override
    public String getId() {
        return cache.getId();
    }

    @Override
    public int getSize() {
        return cache.getSize();
    }

    @Override
    public void putObject(Object key, Object value) {
        cache.putObject(key, value);
    }

    @Override
    public Object getObject(Object key) {
        return cache.getObject(key);
    }

    @Override
    public Object removeObject(Object key) {
        return cache.removeObject(key);
    }

    @Override
    public void clear() {
        cache.clear();
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return cache.getReadWriteLock();
    }

    public boolean equals(Object o) {
        if (getId() == null) throw new CacheException("Cache instances require an ID.");
        if (this == o) return true;
        if (!(o instanceof Cache)) return false;

        Cache otherCache = (Cache) o;
        return getId().equals(otherCache.getId());
    }

    public int hashCode() {
        if (getId() == null) throw new CacheException("Cache instances require an ID.");
        return getId().hashCode();
    }
}
