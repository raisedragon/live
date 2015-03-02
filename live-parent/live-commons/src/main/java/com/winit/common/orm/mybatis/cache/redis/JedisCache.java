package com.winit.common.orm.mybatis.cache.redis;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import org.apache.ibatis.cache.Cache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.Pool;

import com.winit.common.utils.SerializeUtil;

/**
 * 基于redis的mybatis二级缓存实现
 * 
 * @author jianke.zhang 2015-1-15 下午4:53:03
 * @since 1.0
 */
public class JedisCache implements Cache {

    private final Logger              log           = LoggerFactory.getLogger(JedisCache.class);

    /**
     * The cache id (mybatis mapper namespace)
     */
    private final String              id;

    private final ReadWriteLock       readWriteLock = new ReentrantReadWriteLock();

    private static Pool<ShardedJedis> jedisPool     = JedisPoolManager.getJedisPool();

    /**
     * 构造函数
     * 
     * @param id
     */
    public JedisCache(String id){
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }

        // mybatis缓存引用（cache-ref）会用到此ID，不能修改
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    /**
     * 获取一个缓存实例中缓存记录数量
     */
    @Override
    public int getSize() {
        ShardedJedis jedis = null;
        boolean borrowOrOprSuccess = true;
        Long size = 0L;
        try {
            jedis = jedisPool.getResource();
            size = jedis.hlen(SerializeUtil.serialize(this.id));
            if (null == size) size = 0L;
        } catch (JedisConnectionException e) {
            log.error("Unable to obtain the cache instance, please check the configuration file is correct, and sure the network is normal and radis cache server is normal to start", e);
            borrowOrOprSuccess = false;
            if (jedis != null) jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess) jedisPool.returnResource(jedis);
        }
        if (log.isDebugEnabled()) {
            log.debug(String.format("namespace:%s,getSize:%d", this.id, size));
        }
        return size.intValue();
    }

    /**
     * 写入数据至缓存
     */
    @Override
    public void putObject(Object key, Object value) {
        ShardedJedis jedis = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = jedisPool.getResource();
            jedis.hset(SerializeUtil.serialize(this.id), SerializeUtil.serialize(key), SerializeUtil.serialize(value));
        } catch (JedisConnectionException e) {
            log.error("Unable to obtain the cache instance, please check the configuration file is correct, and sure the network is normal and radis cache server is normal to start", e);
            borrowOrOprSuccess = false;
            if (jedis != null) jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess) jedisPool.returnResource(jedis);
        }
        if (log.isDebugEnabled()) {
            log.debug("getObject:" + key + "=" + value);
        }
    }

    /**
     * 从缓存中读取数据
     */
    @Override
    public Object getObject(Object key) {
        ShardedJedis jedis = null;
        boolean borrowOrOprSuccess = true;
        Object value = null;
        try {
            jedis = jedisPool.getResource();
            byte[] byteValue = jedis.hget(SerializeUtil.serialize(this.id), SerializeUtil.serialize(key));
            value = SerializeUtil.unserialize(byteValue);
        } catch (JedisConnectionException e) {
            log.error("Unable to obtain the cache instance, please check the configuration file is correct, and sure the network is normal and radis cache server is normal to start", e);
            borrowOrOprSuccess = false;
            if (jedis != null) jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess) jedisPool.returnResource(jedis);
        }
        if (log.isDebugEnabled()) {
            log.debug("getObject:" + key + "=" + value);
        }
        return value;
    }

    /**
     * 删除缓存中的数据
     */
    @Override
    public Object removeObject(Object key) {
        ShardedJedis jedis = null;
        boolean borrowOrOprSuccess = true;
        Object value = null;
        if (log.isDebugEnabled()) {
            log.debug(String.format("start removeObject; namespace:%s, key:%s", this.id, key));
        }
        try {
            jedis = jedisPool.getResource();
            byte[] byteValue = jedis.hget(SerializeUtil.serialize(this.id), SerializeUtil.serialize(key));
            value = SerializeUtil.unserialize(byteValue);
            jedis.hdel(SerializeUtil.serialize(this.id), SerializeUtil.serialize(key));
        } catch (JedisConnectionException e) {
            log.error("Unable to obtain the cache instance, please check the configuration file is correct, and sure the network is normal and radis cache server is normal to start", e);
            borrowOrOprSuccess = false;
            if (jedis != null) jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess) jedisPool.returnResource(jedis);
        }
        if (log.isDebugEnabled()) {
            log.debug("removeObject:" + key + "=" + value);
        }
        return value;
    }

    /**
     * 清除一个缓存实例中的所有数据
     */
    @Override
    public void clear() {
        ShardedJedis jedis = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = jedisPool.getResource();
            jedis.del(SerializeUtil.serialize(this.id));
        } catch (JedisConnectionException e) {
            log.error("Unable to obtain the cache instance, please check the configuration file is correct, and sure the network is normal and radis cache server is normal to start", e);
            borrowOrOprSuccess = false;
            if (jedis != null) jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess) jedisPool.returnResource(jedis);
        }
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return this.readWriteLock;
    }

}
