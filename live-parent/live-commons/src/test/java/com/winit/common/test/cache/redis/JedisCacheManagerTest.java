package com.winit.common.test.cache.redis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import redis.clients.jedis.ShardedJedis;
import redis.clients.util.Pool;

import com.winit.common.orm.mybatis.cache.redis.JedisPoolManager;

public class JedisCacheManagerTest {

    /**
     * 测试redis客户端分片连接池初始化及连接池操作
     */
    @Test
    public void testGetShardJedisPool() {
        String cacheKey = "mybatis-cache-order";
        String fieldName = "getOrder";
        String fieldValue = "test";
        System.setProperty(JedisPoolManager.RADIS_CONFIG_KEY, "mybatis-redis.properties");
        Pool<ShardedJedis> jedisPool = JedisPoolManager.getJedisPool();
        assertNotNull(jedisPool);

        ShardedJedis shardedJedis = jedisPool.getResource();
        shardedJedis.del(cacheKey);

        assertNotNull(shardedJedis);
        shardedJedis.hset(cacheKey, fieldName, fieldValue);

        String returnValue = shardedJedis.hget(cacheKey, fieldName);
        assertEquals(returnValue, fieldValue);

        long len = shardedJedis.hlen(cacheKey);
        assertEquals(len, 1L);

        shardedJedis.hdel(cacheKey, fieldName);
        returnValue = shardedJedis.hget(cacheKey, fieldName);
        assertEquals(returnValue, null);

        for (int i = 1; i <= 1000; i++) {
            shardedJedis.hset(cacheKey, fieldName + i, fieldValue + i);
        }
        len = shardedJedis.hlen(cacheKey);
        assertEquals(len, 1000);

        returnValue = shardedJedis.hget(cacheKey, fieldName + 100);
        assertEquals(returnValue, fieldValue + 100);

        shardedJedis.del(cacheKey);
        jedisPool.returnResource(shardedJedis);
        
        System.clearProperty(JedisPoolManager.RADIS_CONFIG_KEY);

    }

    /**
     * 测试redis主备+master分片连接池初始化及连接池操作
     */
    @Test
    public void testGetSentinelJedisPool() {
        String cacheKey = "mybatis-cache-order";
        String fieldName = "getOrder";
        String fieldValue = "test";
        System.setProperty(JedisPoolManager.RADIS_CONFIG_KEY, "mybatis-redis-sentinel.properties");
        Pool<ShardedJedis> jedisPool = JedisPoolManager.getJedisPool();
        assertNotNull(jedisPool);

        ShardedJedis shardedJedis = jedisPool.getResource();
        shardedJedis.del(cacheKey);

        assertNotNull(shardedJedis);
        shardedJedis.hset(cacheKey, fieldName, fieldValue);

        String returnValue = shardedJedis.hget(cacheKey, fieldName);
        assertEquals(returnValue, fieldValue);

        long len = shardedJedis.hlen(cacheKey);
        assertEquals(len, 1L);

        shardedJedis.hdel(cacheKey, fieldName);
        returnValue = shardedJedis.hget(cacheKey, fieldName);
        assertEquals(returnValue, null);

        for (int i = 1; i <= 1000; i++) {
            shardedJedis.hset(cacheKey, fieldName + i, fieldValue + i);
        }
        len = shardedJedis.hlen(cacheKey);
        assertEquals(len, 1000);

        returnValue = shardedJedis.hget(cacheKey, fieldName + 100);
        assertEquals(returnValue, fieldValue + 100);

        shardedJedis.del(cacheKey);
        jedisPool.returnResource(shardedJedis);
        
        System.clearProperty(JedisPoolManager.RADIS_CONFIG_KEY);

    }

}
