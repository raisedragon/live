package com.gdcc.live.core.manager;

import java.io.Serializable;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.gdcc.live.core.context.AppContext;
import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.entity.BaseEntity;
import com.gdcc.live.core.identity.IdGenerator;
import com.gdcc.live.core.security.SCUtils;
import com.winit.common.orm.mybatis.PageBase;
import com.winit.common.query.Searchable;

public abstract class AbstractManager<E extends BaseEntity<PK>,PK extends Serializable> implements Manager<E,PK>{

    @Autowired
    protected IdGenerator idGenerator;
    
    @Autowired 
    protected AppContext appContext;

    protected abstract Dao<E, PK> getDao();

    /**
     * 获取实体
     * 
     * @param id 主键标识
     * @return id对应的实体
     */
    public E get(PK id) {
        return getDao().get(id);
    }

    /**
     * 删除实体
     * 
     * @param id 实体id
     */
    public void tombstoned(PK id) {
        getDao().tombstoned(id);
    }

    /**
     * 新增实体
     * 
     * @param entity 实体
     */
    public void add(E entity) {
        if (entity.getCreated() == null) {
            entity.setCreated(new java.util.Date());
        }
        if (entity.getCreatedby() == null) {
            entity.setCreatedby(SCUtils.currentUserId());
        }
        if (entity.getUpdated() == null) {
            entity.setUpdated(new java.util.Date());
        }
        if (entity.getUpdatedby() == null) {
            entity.setUpdatedby(SCUtils.currentUserId());
        }
        if (entity.getOrganizationId() == null) {
            entity.setOrganizationId(SCUtils.currentOrgId());
        }
        getDao().add(entity);
    }

    /**
     * 更新 实体
     * 
     * @param entity 实体
     */
    public void update(E entity) {
        entity.setUpdated(new Date());
        if (entity.getUpdatedby() == null) {
            entity.setUpdatedby(SCUtils.currentUserId());
        }
        getDao().update(entity);
    }

    public PageBase<E> find(Searchable searchable) {
        return getDao().find(searchable);
    }

    /**
     * 设置记录为有效状态
     * 
     * @param id
     */
    public void enable(PK id) {
        getDao().enable(id);
    }

    /**
     * 设置记录为无效状态
     * 
     * @param id
     */
    public void disable(PK id) {
        getDao().disable(id);
    }
}
