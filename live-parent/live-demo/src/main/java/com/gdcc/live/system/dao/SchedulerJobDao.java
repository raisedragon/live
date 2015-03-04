package com.gdcc.live.system.dao;

import java.util.List;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.system.entity.SchedulerJob;
import com.gdcc.live.system.query.SchedulerJobQuery;
import com.winit.common.orm.mybatis.MyBatisRepo;

@MyBatisRepo
public interface SchedulerJobDao extends Dao<SchedulerJob, String> {

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    List<SchedulerJob> queryByCriteria(SchedulerJobQuery.FindQuery query);

    /**
     * 根据查询对象查询
     * 
     * @param query
     * @return
     */
    long queryCountByCriteria(SchedulerJobQuery.FindQuery query);

    /**
     * 根据查询对象更新
     * 
     * @param query
     * @return
     */
    void updateByUpdateQuery(SchedulerJobQuery.UpdateQuery uQuery);

}
