package com.raise.generator.entity;

import com.google.common.base.CaseFormat;

public class TableEntity {

    private String                   name;
    private String                   description;
    private String                   type;

    private String                   jName;
    private String                   jDescription;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getjName() {
        if (jName == null) {
            jName = CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, name);
        }
        return jName;
    }

    public void setjName(String jName) {
        this.jName = jName;
    }

    public String getjDescription() {
        if (jDescription == null) {
            jDescription = description;
        }
        return jDescription;
    }

    public void setjDescription(String jDescription) {
        this.jDescription = jDescription;
    }

}
