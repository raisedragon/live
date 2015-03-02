package com.winit.common.orm.mybatis.cache.redis;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.Protocol;

import com.winit.common.orm.mybatis.cache.exception.MybatisCacheException;

/**
 * redis配置bean
 * 
 * @author jianke.zhang 2015-1-15 下午5:05:30
 * @since 1.0
 */
public class RedisConfig {

    private static final Logger        log                 = LoggerFactory.getLogger(JedisPoolManager.class);

    private static final Mode          DEFAULT_DEPLOY_MODE = Mode.SHARDED;

    private final String               default_config_path = "mybatis-redis.properties";

    private final String               deploy_mode         = "redis.deploy.mode";

    // private final String shard_name_prefix = "shard-";

    private Mode                       deployMode;

    // redis pool config
    private JedisPoolConfig            jedisPoolConfig     = new JedisPoolConfig();

    // deploy_mode = Mode.SHARDED
    private List<SortedJedisShardInfo> shardeds            = new ArrayList<SortedJedisShardInfo>();

    // deploy_mode = Mode.SENTINE
    private List<String>               masters             = new ArrayList<String>();

    // sentinel moniter server
    private Set<String>                sentinels           = new HashSet<String>();
    private int                        sentinelTimeOut     = Protocol.DEFAULT_TIMEOUT;
    private int                        sentinelDatabase    = Protocol.DEFAULT_DATABASE;
    private String                     sentinelPassword    = null;

    public RedisConfig(){
    }

    /**
     * 解析配置信息
     * 
     * @param prop
     */
    public void parse(Properties prop) {
        String key = "";
        String value = null;
        
        String deployMode = prop.getProperty(deploy_mode, DEFAULT_DEPLOY_MODE.key());
        Mode mode = Mode.getByKey(deployMode);
        if (mode == null) {
            throw new MybatisCacheException("Read configuration failed, key:" + deploy_mode);
        }
        this.setDeployMode(mode);

        if (log.isDebugEnabled()) {
            log.debug("radis deploy mode is :" + mode.key());
        }
        
        try {

            int shardedTimeout = Protocol.DEFAULT_TIMEOUT;
            String shardedPassword = null;
            Set<Entry<Object, Object>> entitySet = prop.entrySet();
            SortedJedisShardInfo shardInfo = null;
            for (Iterator<Entry<Object, Object>> iter = entitySet.iterator(); iter.hasNext();) {
                Entry<Object, Object> entity = iter.next();
                key = entity.getKey().toString().trim();
                value = entity.getValue().toString().trim();
                if (key.startsWith("redis.sharded.") && StringUtils.isEmpty(value) && Mode.SHARDED.equals(mode)) {
                    break;
                }
                if (key.startsWith("redis.sharded.") && Mode.SHARDED.equals(mode)) {
                    int dot = key.lastIndexOf(".");

                    // sid将用于分片服务器的排序，影响一致性hash
                    int sid = Integer.parseInt(key.substring(dot + 1));
                    String[] vals = value.split(":");
                    int len = vals.length;
                    if (len < 2) {
                        throw new IllegalArgumentException("redis sharded must contain a host and port, key:" + key);
                    } else if (len == 2) {
                        // 解析host:port
                        shardInfo = new SortedJedisShardInfo(sid, vals[0], Integer.parseInt(vals[1]));
                        shardeds.add(shardInfo);
                    } else if (len == 3) {
                        // 解析host:port:weight
                        shardInfo = new SortedJedisShardInfo(sid,
                            vals[0],
                            Integer.parseInt(vals[1]),
                            Protocol.DEFAULT_TIMEOUT,
                            Integer.parseInt(vals[2]));
                        shardeds.add(shardInfo);
                    } else {
                        throw new IllegalArgumentException("redis sharded only contain [host:port:weight], key:" + key);
                    }
                } else if ("redis.shardeds.timeout".equals(key) && Mode.SHARDED.equals(mode)) {
                    shardedTimeout = Integer.parseInt(value);
                } else if ("redis.shardeds.password".equals(key) && Mode.SHARDED.equals(mode)) {
                    shardedPassword = (StringUtils.isEmpty(value) ? null : value);
                } else if ("redis.master".equals(key) && Mode.SENTINE.equals(mode)) {
                    String[] masterArr = value.split(",");
                    for (String master : masterArr) {
                        master = master.trim();
                        if (!StringUtils.isEmpty(master) && !masters.contains(master)) {
                            masters.add(master);
                        }
                    }
                } else if ("redis.sentinel.server".equals(key) && Mode.SENTINE.equals(mode)) {
                    String[] serverArr = value.split(",");
                    for (String server : serverArr) {
                        server = server.trim();
                        if (!StringUtils.isEmpty(server)) {
                            sentinels.add(server);
                        }
                    }
                } else if ("redis.sentinel.timeout".equals(key) && Mode.SENTINE.equals(mode)) {
                    this.setSentinelTimeOut(Integer.parseInt(value));
                } else if ("redis.sentinel.password".equals(key) && Mode.SENTINE.equals(mode)) {
                    this.setSentinelPassword(value);
                } else if ("redis.sentinel.database".equals(key) && Mode.SENTINE.equals(mode)) {
                    this.setSentinelDatabase(Integer.parseInt(value));
                } else if ("redis.pool.maxTotal".equals(key)) {
                    jedisPoolConfig.setMaxTotal(Integer.parseInt(value));
                } else if ("redis.pool.maxIdle".equals(key)) {
                    jedisPoolConfig.setMaxIdle(Integer.parseInt(value));
                } else if ("redis.pool.minIdle".equals(key)) {
                    jedisPoolConfig.setMinIdle(Integer.parseInt(value));
                } else if ("redis.pool.maxWaitMillis".equals(key)) {
                    jedisPoolConfig.setMaxWaitMillis(Long.parseLong(value));
                } else if ("redis.pool.testOnBorrow".equals(key)) {
                    jedisPoolConfig.setTestOnBorrow(Boolean.parseBoolean(value));
                } else if ("redis.pool.testOnReturn".equals(key)) {
                    jedisPoolConfig.setTestOnReturn(Boolean.parseBoolean(value));
                }
            }

            if (Mode.SHARDED.equals(mode)) {
                for (JedisShardInfo master : shardeds) {
                    master.setTimeout(shardedTimeout);
                    master.setPassword(shardedPassword);
                }

                Collections.sort(shardeds);
            }
        } catch (Exception e) {
            String errorMsg = String.format("Read configuration failed from the [%s] file, key:[%s]", default_config_path, key);
            log.error(errorMsg);
            throw new MybatisCacheException(errorMsg, e);
        }

    }

    public Mode getDeployMode() {
        return deployMode;
    }

    public void setDeployMode(Mode deployMode) {
        this.deployMode = deployMode;
    }

    public JedisPoolConfig getJedisPoolConfig() {
        return jedisPoolConfig;
    }

    public void setJedisPoolConfig(JedisPoolConfig jedisPoolConfig) {
        this.jedisPoolConfig = jedisPoolConfig;
    }

    public List<SortedJedisShardInfo> getShardeds() {
        return shardeds;
    }

    public void setShardeds(List<SortedJedisShardInfo> shardeds) {
        this.shardeds = shardeds;
    }

    public List<String> getMasters() {
        return masters;
    }

    public void setMasters(List<String> masters) {
        this.masters = masters;
    }

    public Set<String> getSentinels() {
        return sentinels;
    }

    public void setSentinels(Set<String> sentinels) {
        this.sentinels = sentinels;
    }

    public int getSentinelTimeOut() {
        return sentinelTimeOut;
    }

    public void setSentinelTimeOut(int sentinelTimeOut) {
        this.sentinelTimeOut = sentinelTimeOut;
    }

    public int getSentinelDatabase() {
        return sentinelDatabase;
    }

    public void setSentinelDatabase(int sentinelDatabase) {
        this.sentinelDatabase = sentinelDatabase;
    }

    public String getSentinelPassword() {
        return sentinelPassword;
    }

    public void setSentinelPassword(String sentinelPassword) {
        this.sentinelPassword = sentinelPassword;
    }

    /**
     * 部署模式
     * 
     * @author jianke.zhang 2015-1-15 下午5:06:29
     * @since 1.0
     */
    public static enum Mode {
        SHARDED("sharded"), // 分片部署
        SENTINE("sharded-sentinel"); // 主备监控+分片部署

        private String key;

        Mode(String key){
            this.key = key;
        }

        public String key() {
            return this.key;
        }

        public static Mode getByKey(String key) {
            if (Mode.SHARDED.key().equals(key)) {
                return Mode.SHARDED;
            } else if (Mode.SENTINE.key().equals(key)) {
                return Mode.SENTINE;
            } else {
                return null;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(Mode.getByKey("sharded"));
        System.out.println(Mode.getByKey("sharded-sentinel"));
        System.out.println(Mode.getByKey("test"));
    }
}
