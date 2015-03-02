package com.winit.common.orm.mybatis;

import java.io.Serializable;

/**
 * MyBatis Repository基类
 *
 * Created by ye.liu on 2014/4/28.
 */
public interface MyBatisBaseRepo<E extends Serializable, ID extends Serializable> {
    /**
     * 获取实体
     * 
     * @param id 主键标识
     * @return id对应的实体
     */
    E get(ID id);

    /**
     * 删除实体
     * 
     * @param id 实体id
     */
    int delete(ID id);

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
}
