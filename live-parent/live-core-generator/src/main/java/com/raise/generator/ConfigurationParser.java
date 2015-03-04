package com.raise.generator;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class ConfigurationParser {
	public static Configuration parse(InputStream in) throws DocumentException {
		Configuration configuration =new Configuration();
		
		SAXReader reader = new SAXReader();
		Document doc = reader.read(in);
		
		//properties
		List<?> propertiesEl = doc.selectNodes("//properties/*");
		Properties properties = new Properties();
		for(Object obj:propertiesEl){
			Element element = (Element)obj;
			properties.put(element.getName(), element.getText());
		}
		
		//templates
		List<?> templatesEl = doc.selectNodes("//templates/template");
		List<Template> templates = new ArrayList<Template>();
		for(Object obj:templatesEl){
			Element element = (Element)obj;
			Template template = new Template();
			template.setId(element.attributeValue("id"));
			template.setPath(element.getText());
			templates.add(template);
		}
		
		//sources
		List<?> sourcesEl = doc.selectNodes("//sources/source");
		List<Source> sources = new ArrayList<Source>();
		for(Object obj:sourcesEl){
			Element element = (Element)obj;
			Source source = new Source();
			source.setRefTemplate(element.attributeValue("refTemplate"));
			source.setDirectory(element.attributeValue("directory"));
			source.setFilename(element.attributeValue("filename"));
			source.setOverride("true".equals(element.attributeValue("override")));
			sources.add(source);
		}
		
		//tables
		List<?> tablesEl = doc.selectNodes("//tables/table");
		List<Table> tables = new ArrayList<Table>();
		for(Object obj:tablesEl){
			Element element = (Element)obj;
			Table table = new Table();
			table.setName(element.elementText("name"));
			table.setClazz(element.elementText("class"));
			table.setPkg(element.elementText("package"));
			table.setModule(element.elementText("module"));
			tables.add(table);
		}
		
		configuration.setProperties(properties);
		configuration.setTemplates(templates);
		configuration.setSources(sources);
		configuration.setTables(tables);
		return configuration;
		
	}
}
