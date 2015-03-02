package com.winit.common.test.cache.redis;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;

import com.winit.common.orm.mybatis.cache.redis.JedisPoolManager;
import com.winit.common.orm.mybatis.cache.redis.RedisConfig;
import com.winit.common.orm.mybatis.cache.redis.RedisConfig.Mode;
import com.winit.common.orm.mybatis.cache.redis.SortedJedisShardInfo;

public class RedisConfigTest {

    @Test
    public void testParse() {
        RedisConfig config = new RedisConfig();
        
        // 清除redis配置文件的系统属性配置，保证服务器进行多次testCase可以正常通过
        System.clearProperty(JedisPoolManager.RADIS_CONFIG_KEY);
        
        String path = System.getProperty(JedisPoolManager.RADIS_CONFIG_KEY, JedisPoolManager.DEFAULT_CONFIG_PATH);
        assertNotNull(path);
        Resource resource = new ClassPathResource(path);
        Properties prop = null;
        try {
            prop = PropertiesLoaderUtils.loadProperties(resource);
            assertNotNull(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }

        config.parse(prop);

        JedisPoolConfig poolConfig = config.getJedisPoolConfig();
        assertEquals(config.getDeployMode(), Mode.SHARDED);
        assertEquals(poolConfig.getMaxTotal(), 1000);
        assertEquals(poolConfig.getMaxIdle(), 100);
        assertEquals(poolConfig.getMinIdle(), 10);
        assertEquals(poolConfig.getMaxWaitMillis(), 1000);
        assertEquals(poolConfig.getTestOnBorrow(), false);
        assertEquals(poolConfig.getTestOnReturn(), false);

        List<SortedJedisShardInfo> shardInfos = config.getShardeds();
        assertEquals(shardInfos.size(), 1);
        JedisShardInfo info = shardInfos.get(0);
        assertEquals(info.getHost(), "192.168.130.111");
        assertEquals(info.getPort(), 6379);
        assertEquals(info.getWeight(), 1);
        assertEquals(info.getTimeout(), 2000);
        //assertEquals(info.getPassword(), "test");
        //info = shardInfos.get(1);
        //assertEquals(info.getHost(), "192.168.130.111");
        //assertEquals(info.getPort(), 6989);
        //assertEquals(info.getWeight(), 2);
        //assertEquals(info.getTimeout(), 2000);
        //assertEquals(info.getPassword(), "test");

        // test sharded-sentinel config
        config = new RedisConfig();

        
        // 清除redis配置文件的系统属性配置，保证服务器进行多次testCase可以正常通过
        System.clearProperty(JedisPoolManager.RADIS_CONFIG_KEY);
        
        path = System.getProperty(JedisPoolManager.RADIS_CONFIG_KEY, "mybatis-redis-sentinel.properties");
        assertNotNull(path);
        resource = new ClassPathResource(path);
        try {
            prop = PropertiesLoaderUtils.loadProperties(resource);
            assertNotNull(prop);
        } catch (IOException e) {
            e.printStackTrace();
        }

        config.parse(prop);

        poolConfig = config.getJedisPoolConfig();
        assertEquals(config.getDeployMode(), Mode.SENTINE);
        assertEquals(poolConfig.getMaxTotal(), 1000);
        assertEquals(poolConfig.getMaxIdle(), 100);
        assertEquals(poolConfig.getMinIdle(), 10);
        assertEquals(poolConfig.getMaxWaitMillis(), 1000);
        assertEquals(poolConfig.getTestOnBorrow(), false);
        assertEquals(poolConfig.getTestOnReturn(), false);
        
        List<String> masters = config.getMasters();
        assertEquals(masters.size(), 1);
        
        Set<String> sentinels = config.getSentinels();
        assertEquals(sentinels.size(), 1);
        
        //assertEquals(config.getSentinelDatabase(), 1);
        //assertEquals(config.getSentinelPassword(), "test");

    }
}
