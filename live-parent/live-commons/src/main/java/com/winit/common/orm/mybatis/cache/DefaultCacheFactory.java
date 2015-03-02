package com.winit.common.orm.mybatis.cache;

import org.apache.ibatis.cache.Cache;

import com.winit.common.orm.mybatis.cache.redis.JedisCache;

/**
 * @author jianke.zhang 2015-1-22 下午4:22:22
 * @since 1.0
 */
public class DefaultCacheFactory extends AbstractCacheFactory {

    @Override
    protected Cache createCache(String id) {
        return new JedisCache(id);
    }

}
