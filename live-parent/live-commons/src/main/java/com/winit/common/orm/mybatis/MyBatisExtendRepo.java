package com.winit.common.orm.mybatis;

import java.io.Serializable;
import java.util.List;

/**
 * MyBatis Repository扩展基类
 *
 * Created by ye.liu on 2014/4/28.
 */
public interface MyBatisExtendRepo<M extends Serializable, ID extends Serializable> extends MyBatisBaseRepo<M, ID> {
    /**
     * 获取全部实体
     * 
     * @return
     */
    List<M> findAll();
}
