package com.winit.common.orm.mybatis.cache.redis;

import org.apache.ibatis.cache.decorators.LoggingCache;
/**
 *  包含日志的redis二级缓存实现
 * @author jianke.zhang 2015-1-15 下午5:04:58
 * @since 1.0
 */
public class LoggingJedis extends LoggingCache {

    public LoggingJedis(final String id){
        super(new JedisCache(id));
    }
}
