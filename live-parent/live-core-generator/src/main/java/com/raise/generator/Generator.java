package com.raise.generator;

import javax.sql.DataSource;

import org.apache.ddlutils.Platform;
import org.apache.ddlutils.PlatformFactory;
import org.apache.ddlutils.model.Database;
import org.apache.ddlutils.model.Table;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.raise.generator.exception.GeneratorException;

@Component
public class Generator {

    private static Logger logger = LoggerFactory.getLogger(Generator.class);

    private Database      database;

    @Autowired
    public Generator(DataSource dataSource){
        Platform platform = PlatformFactory.createNewPlatformInstance(dataSource);
        database = platform.readModelFromDatabase("label");
    }

    public void generated(String tName) throws GeneratorException {
        // step1 - load schema information
        Table table = loadTable(tName);
        // step2 - construct freemarker data model

        // step3 - load freemarker template

        // step4 - generate target content

        // step5 - save target content as file
    }


    private Table loadTable(String tName) throws GeneratorException {
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
