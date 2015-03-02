package com.winit.common.orm.entity;

/**
 * Created by ye.liu on 2014/8/1.
 */
public abstract  class BaseEntity<ID> implements IdEntity<ID> {
    protected ID id;
    @Override
    public ID getId() {
        return id;
    }

    @Override
    public void setId(ID aLong) {
        this.id=id;
    }
}
