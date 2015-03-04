package com.raise.generator;


public enum MySQLDataType {
	INT,
	TINYINT,
	SMALLINT,
	MEDIUMINT,
	BIGINT,
	FLOAT,
	DOUBLE,
	DECIMAL,
	DATE ,
	DATETIME ,
	TIMESTAMP ,
	TIME ,
	YEAR,
	CHAR,
	VARCHAR,
	BLOB ,
	TEXT ,
	TINYBLOB ,
	TINYTEXT ,
	MEDIUMBLOB ,
	MEDIUMTEXT ,
	LONGBLOB ,
	LONGTEXT ,
	ENUM ;
    public String value() {
        return name();
    }

    public static MySQLDataType fromValue(String v) {
        return valueOf(v);
    }
}
