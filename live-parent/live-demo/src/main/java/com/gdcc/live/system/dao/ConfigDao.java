package com.gdcc.live.system.dao;

import java.util.List;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.system.entity.Config;
import com.gdcc.live.system.query.ConfigQuery;
import com.winit.common.orm.mybatis.MyBatisRepo;

@MyBatisRepo
public interface ConfigDao extends Dao<Config, String> {

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

}
