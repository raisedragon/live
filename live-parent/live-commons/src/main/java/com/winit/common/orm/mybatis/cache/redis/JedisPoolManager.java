package com.winit.common.orm.mybatis.cache.redis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.util.Pool;

import com.winit.common.orm.mybatis.cache.exception.MybatisCacheException;
import com.winit.common.orm.mybatis.cache.redis.RedisConfig.Mode;

public class JedisPoolManager {

    private static final Logger       log                 = LoggerFactory.getLogger(JedisPoolManager.class);

    /**
     * redis配置文件路径读取key，System.getProperty(key);
     */
    public static final String        RADIS_CONFIG_KEY    = "mybatis.redis.config";

    /**
     * 默认redis配置文件名称
     */
    public static final String        DEFAULT_CONFIG_PATH = "mybatis-redis.properties";

    /**
     * jedis连接池，基于common-pool2
     */
    private static Pool<ShardedJedis> pool;

    /**
     * 获取jedis连接池
     * 
     * @return
     */
    public synchronized static Pool<ShardedJedis> getJedisPool() {
        if (null == pool) {
            pool = initPool();
        }
        return pool;
    }

    /**
     * 初始化jedis连接池
     */
    private static Pool<ShardedJedis> initPool() {
        String path = System.getProperty(RADIS_CONFIG_KEY, DEFAULT_CONFIG_PATH);

        if (log.isDebugEnabled()) {
            log.debug("Start loading the radis configuration file:" + path);
        }

        Resource resource = new ClassPathResource(path);
        Properties prop = null;
        Pool<ShardedJedis> pool = null;
        RedisConfig config = new RedisConfig();

        try {
            // 加载redis配置文件
            prop = PropertiesLoaderUtils.loadProperties(resource);
        } catch (IOException e) {
            log.error("Could not load the radis configuration file:" + DEFAULT_CONFIG_PATH);
            throw new MybatisCacheException(e);
        }

        // 解析redis配置
        config.parse(prop);

        if (log.isDebugEnabled()) {
            log.debug("The radis configuration is loaded");
        }

        if (Mode.SENTINE.equals(config.getDeployMode())) {
            // 如果redis部署模式是分片模式
            pool = initShardedJedisSentinelPool(config);
        } else if (Mode.SHARDED.equals(config.getDeployMode())) {
            // 如果redis部署模式是主备加分片模式
            pool = initShardedJedisPool(config);
        } else {
            return null;
        }

        // test getJedis from cache pool
        testCache(pool);

        return pool;
    }

    /**
     * 测试从连接池中获取jedis客户端连接及回收连接
     * 
     * @param jedisPool
     */
    private static void testCache(Pool<ShardedJedis> jedisPool) {
        ShardedJedis jedis = null;
        boolean borrowOrOprSuccess = true;
        try {
            jedis = jedisPool.getResource();
        } catch (JedisConnectionException e) {
            log.error("Unable to obtain the cache instance, please check the configuration file is correct, and sure the network is normal and radis cache server is normal to start", e);
            borrowOrOprSuccess = false;
            if (jedis != null) jedisPool.returnBrokenResource(jedis);
        } finally {
            if (borrowOrOprSuccess) jedisPool.returnResource(jedis);
        }
        if (log.isDebugEnabled()) {
            log.debug("");
        }
    }

    /**
     * 初始化jedis分片部署的连接池
     * 
     * @param config
     * @return
     */
    private static ShardedJedisPool initShardedJedisPool(RedisConfig config) {
        List<JedisShardInfo> masters = new ArrayList<JedisShardInfo>();
        masters.addAll(config.getShardeds());
        JedisPoolConfig poolConfig = config.getJedisPoolConfig();
        ShardedJedisPool pool = new ShardedJedisPool(poolConfig, masters);
        return pool;
    }

    /**
     * 初始化通过sentinel监控主备切换服务的jedis连接池
     * 
     * @param config
     * @return
     */
    private static ShardedJedisSentinelPool initShardedJedisSentinelPool(RedisConfig config) {
        JedisPoolConfig poolConfig = config.getJedisPoolConfig();
        List<String> masters = config.getMasters();
        Set<String> sentinels = config.getSentinels();
        ShardedJedisSentinelPool pool = new ShardedJedisSentinelPool(poolConfig, masters, sentinels);
        return pool;
    }

}
