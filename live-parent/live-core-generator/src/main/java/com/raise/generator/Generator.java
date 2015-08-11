package com.raise.generator;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.generator.entity.ColumnEntity;
import com.raise.generator.entity.Configuration;
import com.raise.generator.entity.TableEntity;
import com.raise.generator.exception.GeneratorException;
import com.raise.generator.freemarker.FreemarkEngine;

import freemarker.template.TemplateException;

@Component
public class Generator {

    private static Logger logger = LoggerFactory.getLogger(Generator.class);

    private Database      database;

    @Autowired
    private FreemarkEngine freemarkerEngine;

    @Autowired
    private Configuration  configuration;

    @Autowired
    private List<TableEntity> entities;

    @Autowired
    public Generator(DataSource dataSource) throws IllegalAccessException, InvocationTargetException,
                                           GeneratorException{
        Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
        database = platform.readModelFromDatabase("label");

        for (TableEntity t : entities) {
            Table table = loadTable(t.getName());
            BeanUtils.copyProperties(table, t);
        }

        System.out.println(entities);

    }


    public void generated(String tName) throws GeneratorException {
        // step1 - load schema information
        // Table table = loadTable(tName);
        // step2 - construct freemarker data model

        // step3 - load freemarker template

        // step4 - generate target content

        // step5 - save target content as file
    }

    public void generated(TableEntity table) throws IOException, TemplateException {
        Map<String, Object> data = new HashMap<String, Object>();
        String out;
        
        data.put("table", table);
        data.put("configuration", configuration);
        for (ColumnEntity column : table.getColumns()) {
            if (column.getjType().isEnum() && column.getjType().isCreate()) {
                data.put("enum", column.getjType());
                out = freemarkerEngine.parse("enum.ftl", data);
                System.out.println(out);
            }
        }
        
        out = freemarkerEngine.parse("entity.ftl", data);
        System.out.println(out);
    }

    private Table loadTable(String tName) throws GeneratorException, IllegalAccessException,
                                               InvocationTargetException {
        Table table = database.findTable(tName);
        if (table == null) {
            throw new GeneratorException("table with name %s not found");
        }
        return table;
    }

    // getter and setter

    public Database getDatabase() {
        return database;
    }

    public void setDatabase(Database database) {
        this.database = database;
    }
}
