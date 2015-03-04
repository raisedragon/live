package com.raise.freemarker;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import freemarker.ext.beans.BeansWrapper;
import freemarker.template.Configuration;
import freemarker.template.TemplateHashModel;

public class FreemarkerUtils {
	private static Logger log = LoggerFactory.getLogger(FreemarkerUtils.class);

	public static Configuration getConfig() {
		Configuration config = new Configuration();
		BeansWrapper wrapper = (BeansWrapper) BeansWrapper.BEANS_WRAPPER;  
		wrapper.setExposureLevel(BeansWrapper.EXPOSE_ALL);
		InputStream in = null;
		try {
			in = FreemarkerUtils.class
					.getResourceAsStream("/freemarker/conf/freemarkerstatic.properties");
			if (in != null)
			{
				Properties props = new Properties();
				props.load(in);
				;
				Enumeration<Object> en = props.keys();
				String name, value;
				TemplateHashModel staticModels = wrapper.getStaticModels();
				while (en.hasMoreElements()) {
					name = (String) en.nextElement();
					value = props.getProperty(name);
					TemplateHashModel tempStatics = (TemplateHashModel) staticModels
							.get(value);
					config.setSharedVariable(name, tempStatics);
				}
			}
		} catch (Exception ex) {
			log.error(
					"Error while loading freemarker settings from /freemarkerstatic.properties",
					ex);
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				in = null;
			}
		}
		config.setObjectWrapper(wrapper);
		
		
		File directory = new File(FreemarkerUtils.class.getResource("/freemarker/template").getFile());
		try {
			config.setDirectoryForTemplateLoading(directory);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return config;
	}
}
