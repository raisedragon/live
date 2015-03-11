package com.raise.generator;


import java.util.ArrayList;
import java.util.List;

import com.google.common.base.CaseFormat;

import schemacrawler.schema.Column;
import schemacrawler.schema.PrimaryKey;

public class Ongl {
	public static String javaType(PrimaryKey key) {
		String dbDataType =  key.getColumns().get(0).getColumnDataType().getName();
		return javaType(dbDataType);
	}
	

	public static String javaType(String dbDataType) {
		MySQLDataType type = MySQLDataType.fromValue(dbDataType);
		String jType = "String";

		switch (type) {
		case INT:
			jType = "Integer";
			break;
		case TINYINT:
			jType = "Integer";
			break;
		case SMALLINT:
			jType = "Integer";
			break;
		case MEDIUMINT:
			jType = "Integer";
			break;
		case BIGINT:
			jType = "Long";
			break;
		case FLOAT:
			jType = "Float";
			break;
		case DOUBLE:
			jType = "Double";
			break;
		case DECIMAL:
			jType = "BigDecimal";
			break;
		case DATE:
			jType = "Date";
			break;
		case DATETIME:
			jType = "Date";
			break;
		case TIMESTAMP:
			jType = "Date";
			break;
		case TIME:
			jType = "Date";
			break;
		case YEAR:
			jType = "Date";
			break;
		case CHAR:
			jType = "String";
			break;
		case VARCHAR:
			jType = "String";
			break;
		case BLOB:
			jType = "Byte[]";
			break;
		case TEXT:
			jType = "String";
			break;
		case TINYBLOB:
			jType = "Byte[]";
			break;
		case TINYTEXT:
			jType = "String";
			break;
		case MEDIUMBLOB:
			jType = "Byte[]";
			break;
		case MEDIUMTEXT:
			jType = "String";
			break;
		case LONGBLOB:
			jType = "Byte[]";
			break;
		case LONGTEXT:
			jType = "String";
			break;
		case ENUM:
			jType = "String";
			break;
		default:
			jType = "String";
			break;
		}
		return jType;
	}
	
	public static String mybatisType(Column column){
		return mybatisType(column.getColumnDataType().getName());
	}

	public static String mybatisType(String dbDataType) {
		MySQLDataType type = MySQLDataType.fromValue(dbDataType);
		String jType = "String";

		switch (type) {
		case INT:
			jType = "INTEGER";
			break;
		case TINYINT:
			jType = "TINYINT";
			break;
		case SMALLINT:
			jType = "SMALLINT";
			break;
		case MEDIUMINT:
			jType = "INTEGER";
			break;
		case BIGINT:
			jType = "BIGINT";
			break;
		case FLOAT:
			jType = "FLOAT";
			break;
		case DOUBLE:
			jType = "DOUBLE";
			break;
		case DECIMAL:
			jType = "DECIMAL";
			break;
		case DATE:
			jType = "DATE";
			break;
		case DATETIME:
			jType = "DATE";
			break;
		case TIMESTAMP:
			jType = "TIMESTAMP";
			break;
		case TIME:
			jType = "TIME";
			break;
		case YEAR:
			jType = "VARCHAR";
			break;
		case CHAR:
			jType = "CHAR";
			break;
		case VARCHAR:
			jType = "VARCHAR";
			break;
		case BLOB:
			jType = "BLOB";
			break;
		case TEXT:
			jType = "CLOB";
			break;
		case TINYBLOB:
			jType = "BLOB";
			break;
		case TINYTEXT:
			jType = "CLOB";
			break;
		case MEDIUMBLOB:
			jType = "BLOB";
			break;
		case MEDIUMTEXT:
			jType = "CLOB";
			break;
		case LONGBLOB:
			jType = "BLOB";
			break;
		case LONGTEXT:
			jType = "CLOB";
			break;
		case ENUM:
			jType = "VARCHAR";
			break;
		default:
			jType = "VARCHAR";
			break;
		}
		return jType;
	}
	
	
	private static List<String> commonColumns = new ArrayList<String>();
	static{
		commonColumns.add("ID");
		commonColumns.add("CREATED");
		commonColumns.add("CREATEDBY");
		commonColumns.add("UPDATED");
		commonColumns.add("UPDATEDBY");
		commonColumns.add("ISDELETED");
		commonColumns.add("ORGANIZATIONID");
	}
	
	public static boolean isCommonColumn(Column column){
		return commonColumns.contains(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.UPPER_CAMEL, column.getName()).toUpperCase());
	}
	
	public static void main(String[] args) {
//		System.out.println(Integer.MAX_VALUE);
		
		String a  = "abc${b}}";
		a = a.replaceAll("\\$\\{[^\\}+]}", "....");
		System.out.println(a);
	}
}
