package com.raise.generator;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.apache.commons.io.FilenameUtils;
import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Column;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.generator.entity.ColumnEntity;
import com.raise.generator.entity.Configuration;
import com.raise.generator.entity.JavaTypeEntity;
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
    private DataSource        dataSource;

    @PostConstruct
    public void init() throws IllegalAccessException, InvocationTargetException,
                                           GeneratorException{
        Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
        database = platform.readModelFromDatabase("label");

        for (TableEntity t : entities) {
            Table table = loadTable(t.getName());
            t.setDescription(table.getDescription());
            t.setType(table.getName());
            Map<String, ColumnEntity> columns = new HashMap<String, ColumnEntity>();
            List<ColumnEntity> list = new ArrayList<ColumnEntity>();
            for (ColumnEntity c : t.getColumns()) {
                columns.put(c.getName().toUpperCase(), c);
            }
            for (Column column : table.getColumns()) {
                ColumnEntity c = null;
                if (columns.containsKey(column.getName().toUpperCase())) {
                    c = columns.get(column.getName().toUpperCase());
                } else {
                    c = new ColumnEntity();
                    c.setName(column.getName());
                }
                c.setAutoIncrement(column.isAutoIncrement());
                c.setDescription(column.getDescription());
                c.setType(column.getType());
                c.setPrimaryKey(column.isPrimaryKey());
                c.setRequired(column.isRequired());
                list.add(c);

            }
            t.setColumns(list);
        }


        System.out.println(entities);

    }


    public void generated() throws GeneratorException, IOException, TemplateException {
        // step1 - load schema information
        // Table table = loadTable(tName);
        // step2 - construct freemarker data model

        // step3 - load freemarker template

        // step4 - generate target content

        // step5 - save target content as file
        for (TableEntity t : entities) {
            generated(t);
        }

    }

    public void generated(TableEntity table) throws IOException, TemplateException {
        Map<String, Object> data = new HashMap<String, Object>();
        

        data.put("table", table);
        data.put("configuration", configuration);
        for (ColumnEntity column : table.getColumns()) {
            if (column.getjType().isEnum() && column.getjType().isCreate()) {
                data.put("enum", column.getjType());
                String out = freemarkerEngine.parse("enum.ftl", data);
                System.out.println(out);
                String file = getEnumFullFileName(table, column.getjType());
                saveFile(file, out);
            }
        }
        
        String out = freemarkerEngine.parse("entity.ftl", data);
        String file = getEntityFullFileName(table);
        saveFile(file, out);

    }

    private String getEntityFullFileName(TableEntity table) {
        StringBuffer sbuf = new StringBuffer();

        sbuf.append(configuration.getOutputDirectory());
        sbuf.append(File.separator);
        sbuf.append(configuration.getGroupId().replace(".", File.separator));
        sbuf.append(File.separator);
        sbuf.append(configuration.getSystem());
        sbuf.append(File.separator);
        sbuf.append(table.getModule());
        sbuf.append(File.separator);
        sbuf.append("entity");
        sbuf.append(File.separator);
        sbuf.append(table.getjName());
        sbuf.append(".java");
        return sbuf.toString();
    }

    private String getEnumFullFileName(TableEntity table, JavaTypeEntity jtype) {
        StringBuffer sbuf = new StringBuffer();

        sbuf.append(configuration.getOutputDirectory());
        sbuf.append(File.separator);
        sbuf.append(configuration.getGroupId().replace(".", File.separator));
        sbuf.append(File.separator);
        sbuf.append(configuration.getSystem());
        sbuf.append(File.separator);
        sbuf.append(table.getModule());
        sbuf.append(File.separator);
        sbuf.append("entity");
        sbuf.append(File.separator);
        sbuf.append(jtype.getName());
        sbuf.append(".java");
        return sbuf.toString();
    }

    private void saveFile(String file, String content) {
        File dir = new File(FilenameUtils.getFullPathNoEndSeparator(file));
        if (!dir.exists()) {
            dir.mkdirs();
        }
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(content.getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

        }
    }

    private Table loadTable(String tName) throws GeneratorException, IllegalAccessException,
                                               InvocationTargetException {
        Table table = database.findTable(tName);
        if (table == null) {
            throw new GeneratorException(String.format("table with name %s not found", tName));
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
