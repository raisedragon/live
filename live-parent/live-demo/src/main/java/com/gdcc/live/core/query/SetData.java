package com.gdcc.live.core.query;

public class SetData {

    private String property;

    private Object value;

    public SetData(String property, Object value){
        this.value = value;
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public Object getValue() {
        return value;
    }

}
