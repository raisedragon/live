package com.winit.common.orm.mybatis.cache.redis;

import java.net.URI;

import redis.clients.jedis.JedisShardInfo;

/**
 * 可排序分片信息类
 * 
 * @author jianke.zhang 2015-1-15 下午5:08:44
 * @since 1.0
 */
public class SortedJedisShardInfo extends JedisShardInfo implements Comparable<SortedJedisShardInfo> {

    private int serverId;

    public SortedJedisShardInfo(int serverId, String host){
        super(host);
        this.serverId = serverId;
    }

    public SortedJedisShardInfo(int serverId, String host, int port, int timeout, int weight){
        super(host, port, timeout, weight);
        this.serverId = serverId;
    }

    public SortedJedisShardInfo(int serverId, String host, int port, int timeout, String name){
        super(host, port, timeout, name);
        this.serverId = serverId;
    }

    public SortedJedisShardInfo(int serverId, String host, int port, int timeout){
        super(host, port, timeout);
        this.serverId = serverId;
    }

    public SortedJedisShardInfo(int serverId, String host, int port, String name){
        super(host, port, name);
        this.serverId = serverId;
    }

    public SortedJedisShardInfo(int serverId, String host, int port){
        super(host, port);
        this.serverId = serverId;
    }

    public SortedJedisShardInfo(int serverId, String host, String name){
        super(host, name);
        this.serverId = serverId;
    }

    public SortedJedisShardInfo(int serverId, URI uri){
        super(uri);
        this.serverId = serverId;
    }

    public int getServerId() {
        return serverId;
    }

    public void setServerId(int serverId) {
        this.serverId = serverId;
    }

    @Override
    public int compareTo(SortedJedisShardInfo o) {
        if (o == null) {
            return 1;
        }
        return (this.serverId < o.serverId ? -1 : (this.serverId == o.serverId ? 0 : 1));
    }

}
