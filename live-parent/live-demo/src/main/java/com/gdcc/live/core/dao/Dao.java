package com.gdcc.live.core.dao;

import java.io.Serializable;

import com.winit.common.orm.mybatis.MyBatisPageRepo;

public interface Dao<M extends Serializable, PK extends Serializable> extends MyBatisPageRepo<M, PK> {

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
     * 逻辑删除记录
     * 
     * @param id
     */
    void tombstoned(PK id);
}
