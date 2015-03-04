package com.gdcc.live.system.manager;

import java.util.List;

import com.gdcc.live.core.manager.Manager;
import com.gdcc.live.system.entity.Config;
import com.gdcc.live.system.query.ConfigQuery;

public interface ConfigManager extends Manager<Config,String> {

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    List<Config> queryByCriteria(ConfigQuery.FindQuery query);

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    long queryCountByCriteria(ConfigQuery.FindQuery query);

    /**
     * 根据查询对象更新
     * 
     * @param query
     * @return
     */
    void updateByUpdateQuery(ConfigQuery.UpdateQuery uQuery);

    /**
     * 设置记录为有效状态
     * 
     * @param id
     */
    void enable(String id);

    /**
     * 设置记录为无效状态
     * 
     * @param id
     */
    void disable(String id);

    /**
     * 获取配置项
     * 
     * @param name
     * @return
     */
    String getValue(String name);

    /**
     * 设置配置项
     * 
     * @param name
     * @param value
     * @return
     */
    void setValue(String name, String value);

    /**
     * 获取系统配置
     * 
     * @param name 配置项名
     * @return
     */
    Config getByName(String name);
}
