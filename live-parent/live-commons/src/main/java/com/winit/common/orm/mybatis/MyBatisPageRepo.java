package com.winit.common.orm.mybatis;

import java.io.Serializable;

import com.winit.common.query.Searchable;

/**
 *
 * Created by ye.liu on 2014/4/28.
 */
public interface MyBatisPageRepo<M extends Serializable, ID extends Serializable> extends MyBatisBaseRepo<M, ID> {
    PageBase<M> find(Searchable searchable);
}
