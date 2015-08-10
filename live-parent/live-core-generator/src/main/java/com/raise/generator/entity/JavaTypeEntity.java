package com.raise.generator.entity;

import java.util.ArrayList;
import java.util.List;


public class JavaTypeEntity {

    private String  name;
    private List<String> values;
    private boolean      create;

    public boolean isEnum() {
        if (values != null && values.size() > 0) {
            return true;
        }
        return false;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getValues() {
        if (values == null) {
            values = new ArrayList<String>();
        }
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }

    public boolean isCreate() {
        return create;
    }

    public void setCreate(boolean create) {
        this.create = create;
    }

}
