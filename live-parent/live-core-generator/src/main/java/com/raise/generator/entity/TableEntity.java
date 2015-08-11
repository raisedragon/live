package com.raise.generator.entity;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.CaseFormat;

public class TableEntity {

    private String             name;
    private String             description;
    private String             type;

    private String             jName;
    private String             jDescription;
    private String             module;

    private List<ColumnEntity> columns;

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

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public List<ColumnEntity> getColumns() {
        if (this.columns == null) {
            this.columns = new ArrayList<ColumnEntity>();
        }
        return columns;
    }

    public void setColumns(List<ColumnEntity> columns) {
        this.columns = columns;
    }

    public String getPrimaryKeyJavaType() {
        for (ColumnEntity c : getColumns()) {
            if (c.isPrimaryKey()) {
                return c.getjType().getName();
            }
        }
        return "Long";
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
