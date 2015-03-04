package com.gdcc.live.system.manager;

import java.util.List;

import com.gdcc.live.core.manager.Manager;
import com.gdcc.live.system.entity.SchedulerJob;
import com.gdcc.live.system.query.SchedulerJobQuery;

public interface SchedulerJobManager extends Manager<SchedulerJob,String> {

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
}
