package com.raise.generator.entity;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class TableEntityTest extends TableEntity {

    @Test
    public void test() {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setDescription("description");
        tableEntity.setName("table");
        tableEntity.setjName("Table");
        tableEntity.setjDescription("jDescription");
        tableEntity.setType("table");
        for (int i = 0; i < 5; i++) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setAutoIncrement(false);
            columnEntity.setDescription("description" + i);
            columnEntity.setjDescription("jDescription" + i);
            columnEntity.setjName("jName" + i);
            JavaTypeEntity type = new JavaTypeEntity();
            type.setName("String");
            columnEntity.setjType(type);
            columnEntity.setName("name" + i);
            columnEntity.setPrimaryKey(false);
            columnEntity.setRequired(false);
            columnEntity.setType("type" + i);
            tableEntity.getColumns().add(columnEntity);
        }
        List<String> values = new ArrayList<String>();
        values.add("A");
        values.add("B");
        tableEntity.getColumns().get(tableEntity.getColumns().size() - 1).getjType().setValues(values);

    }

}
