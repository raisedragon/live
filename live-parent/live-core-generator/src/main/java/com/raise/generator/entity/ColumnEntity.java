package com.raise.generator.entity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.google.common.base.CaseFormat;

public class ColumnEntity {

    private String                           name;
    private String                           description;
    private boolean                          primaryKey;
    private boolean                          required;
    private boolean                          autoIncrement;
    private String                           type;

    private String                           jName;
    private String                           jDescription;

    private JavaTypeEntity                   jType;

    private static final Set<String>         COMMON_COLUMNS = new HashSet<String>();
    static {
        COMMON_COLUMNS.add("ID");
        COMMON_COLUMNS.add("CREATED");
        COMMON_COLUMNS.add("CREATED_BY");
        COMMON_COLUMNS.add("UPDATED");
        COMMON_COLUMNS.add("UPDATED_BY");
        COMMON_COLUMNS.add("ORGANIZATION_ID");
        COMMON_COLUMNS.add("IS_DELETE");
    }

    private static final Map<String, String> TYPE_MAP       = new HashMap<String, String>();
    static {
        TYPE_MAP.put("varchar", "String");
        TYPE_MAP.put("TEXT", "String");
        TYPE_MAP.put("INTEGER", "Integer");
        TYPE_MAP.put("INT", "Integer");
        TYPE_MAP.put("DECIMAL", "BigDecimal");

    }

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

    public boolean isPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(boolean primaryKey) {
        this.primaryKey = primaryKey;
    }

    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }

    public boolean isAutoIncrement() {
        return autoIncrement;
    }

    public void setAutoIncrement(boolean autoIncrement) {
        this.autoIncrement = autoIncrement;
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

    public String getjNameLowerCamel() {
        return CaseFormat.UPPER_CAMEL.to(CaseFormat.LOWER_CAMEL, jName);
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

    public JavaTypeEntity getjType() {
        return jType;
    }

    public void setjType(JavaTypeEntity jType) {
        this.jType = jType;
    }

    public boolean isCommonColumn() {
        if (COMMON_COLUMNS.contains(this.name.toUpperCase())) {
            return true;
        }
        return false;
    }

}
