package com.raise.generator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.raise.generator.entity.ColumnEntity;
import com.raise.generator.entity.JavaTypeEntity;
import com.raise.generator.entity.TableEntity;
import com.raise.generator.exception.GeneratorException;
import com.raise.generator.test.BaseTestCase;

import freemarker.template.TemplateException;

public class T1 extends BaseTestCase {

    private static Logger logger = LoggerFactory.getLogger(T1.class);

    @Resource
    private Generator     generator;

    @Test
    public void test() throws GeneratorException, IOException, TemplateException {
        TableEntity tableEntity = new TableEntity();
        tableEntity.setDescription("description");
        tableEntity.setName("table");
        tableEntity.setjName("Table");
        tableEntity.setjDescription("jDescription");
        tableEntity.setType("table");
        tableEntity.setModule("test");
        for (int i = 0; i < 5; i++) {
            ColumnEntity columnEntity = new ColumnEntity();
            columnEntity.setAutoIncrement(false);
            columnEntity.setDescription("description" + i);
            columnEntity.setjDescription("jDescription" + i);
            columnEntity.setjName("jName" + i);

            JavaTypeEntity type = new JavaTypeEntity();
            if (i == 4) {
                type.setName("Status");
                List<String> values = new ArrayList<String>();
                values.add("A");
                values.add("B");
                type.setValues(values);
                type.setCreate(true);
            } else {
                type.setName("String");
            }
            columnEntity.setjType(type);
            columnEntity.setName("name" + i);
            columnEntity.setPrimaryKey(false);
            columnEntity.setRequired(false);
            columnEntity.setType("type" + i);
            tableEntity.getColumns().add(columnEntity);
        }

        generator.generated(tableEntity);
    }
}
