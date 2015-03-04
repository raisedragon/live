package com.gdcc.live.core.manager;

import java.io.Serializable;

import com.gdcc.live.core.entity.BaseEntity;
import com.winit.common.orm.mybatis.PageBase;
import com.winit.common.query.Searchable;

public interface Manager<E extends BaseEntity<PK>, PK extends Serializable> {

    /**
     * 获取实体
     * 
     * @param id 主键标识
     * @return id对应的实体
     */
    E get(PK id);

    /**
     * 新增实体
     * 
     * @param entity 实体
     */
    void add(E entity);

    /**
     * 更新 实体
     * 
     * @param entity 实体
     */
    void update(E entity);

    PageBase<E> find(Searchable searchable);

    /**
     * 设置记录为有效状态
     * 
     * @param id
     */
    void enable(PK id);

    /**
     * 设置记录为无效状态
     * 
     * @param id
     */
    void disable(PK id);

    /**
     * 删除实体
     * 
     * @param id 实体id
     */
    void tombstoned(PK id);
}
