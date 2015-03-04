package com.gdcc.live.system.manager.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.manager.AbstractManager;
import com.gdcc.live.system.dao.SchedulerJobDao;
import com.gdcc.live.system.entity.SchedulerJob;
import com.gdcc.live.system.manager.SchedulerJobManager;
import com.gdcc.live.system.query.SchedulerJobQuery;

public class SchedulerJobManagerImpl extends AbstractManager<SchedulerJob,String> implements SchedulerJobManager {

    @Resource
    SchedulerJobDao schedulerJobDao;

    @Override
    protected Dao<SchedulerJob, String> getDao() {
        return schedulerJobDao;
    }

    @Override
    public List<SchedulerJob> queryByCriteria(SchedulerJobQuery.FindQuery query) {
        return schedulerJobDao.queryByCriteria(query);
    }

    @Override
    public long queryCountByCriteria(SchedulerJobQuery.FindQuery query) {
        return schedulerJobDao.queryCountByCriteria(query);
    }

    @Override
    public void updateByUpdateQuery(SchedulerJobQuery.UpdateQuery uQuery) {
        schedulerJobDao.updateByUpdateQuery(uQuery);
    }

}
