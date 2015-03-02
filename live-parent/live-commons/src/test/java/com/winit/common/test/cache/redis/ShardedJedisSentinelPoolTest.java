package com.winit.common.test.cache.redis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.exceptions.JedisConnectionException;

import com.winit.common.orm.mybatis.cache.redis.ShardedJedisSentinelPool;

public class ShardedJedisSentinelPoolTest {

    /**
     * 测试redis主从，master分片连接池
     */
    @Test
    public void test() {
        String cacheKey = "mybatis-cache-order";
        String fieldName = "getOrder";
        String fieldValue = "test";

        JedisPoolConfig config = new JedisPoolConfig();
        config.setTestOnBorrow(true);

        List<String> masters = new ArrayList<String>();
        masters.add("master-6379-6479");

        Set<String> sentinels = new HashSet<String>();
        sentinels.add("192.168.130.111:26379");

        ShardedJedisSentinelPool jedisPool = new ShardedJedisSentinelPool(config, masters, sentinels);

        ShardedJedis shardedJedis = jedisPool.getResource();
        assertNotNull(jedisPool);

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

        for (int i = 1; i <= 100; i++) {
            shardedJedis.hset(cacheKey, fieldName + i, fieldValue + i);
        }
        len = shardedJedis.hlen(cacheKey);
        assertEquals(len, 100);

        returnValue = shardedJedis.hget(cacheKey, fieldName + 10);
        assertEquals(returnValue, fieldValue + 10);

        // shardedJedis.del(cacheKey);
        jedisPool.returnResource(shardedJedis);
    }

    public static void main(String[] args) {
        
        JedisPoolConfig config = new JedisPoolConfig();
        config.setTestOnBorrow(true);

        List<String> masters = new ArrayList<String>();
        masters.add("master-6379-6479");

        Set<String> sentinels = new HashSet<String>();
        sentinels.add("192.168.130.111:26379");

        final ShardedJedisSentinelPool jedisPool = new ShardedJedisSentinelPool(config, masters, sentinels);

        Thread thread = new Thread(new Runnable() {

            /**
             * 运行2分钟,测试redis主从切换
             */
            @Override
            public void run() {
                long runTime = 2 * 60 * 1000;
                long startTime = System.currentTimeMillis();
                long endTime = 0;
                int idx = 1;
                while ((endTime - startTime < runTime)) {
                    boolean borrowOrOprSuccess = true;
                    ShardedJedis shardedJedis = null;
                    try {
                        shardedJedis = jedisPool.getResource();
                        String field = "field" + (idx++);
                        shardedJedis.hset("testhash", field, field);
                        Thread.sleep(1000);
                        System.err.println("-------hget-------" + shardedJedis.hget("testhash", field));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (JedisConnectionException e) {
                        borrowOrOprSuccess = false;
                        if (shardedJedis != null) jedisPool.returnBrokenResource(shardedJedis);
                    } finally {
                        if (borrowOrOprSuccess) jedisPool.returnResource(shardedJedis);
                    }
                    endTime = System.currentTimeMillis();
                }
            }
        });
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.exit(0);
    }

}
