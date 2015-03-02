package com.winit.common.orm.mybatis.cache;

import org.apache.ibatis.cache.Cache;

/**
 * @author jianke.zhang 2015-1-15 下午4:20:37
 * @since 1.0
 */
public interface CacheFactory {

    /**
     * 获取缓存对象
     * 
     * @param id
     * @return
     */
    Cache getCache(String id);
}
