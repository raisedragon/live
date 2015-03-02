package com.winit.common.orm.entity;

import java.io.Serializable;

/**
 * Created by ye.liu on 2014/8/1.
 */
public interface IdEntity<ID> extends Serializable {
    ID getId();

    void setId(ID id);
}
