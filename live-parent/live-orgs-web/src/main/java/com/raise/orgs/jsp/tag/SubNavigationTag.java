package com.raise.orgs.jsp.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import org.springframework.core.io.ClassPathResource;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;

import com.raise.orgs.ProcessEngineConfiguration;
import com.raise.orgs.identity.User;
import com.raise.orgs.impl.cfg.ProcessEngineConfigurationImpl;
import com.raise.orgs.impl.context.Context;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class SubNavigationTag extends SimpleTagSupport {
	
	
	public void doTag() throws JspException, IOException {
		User user = Context.getUser();
		Map<String,Object> dataModel = new HashMap<String,Object>();
	
		List<Menu> menus = new ArrayList<Menu>();
		//TODO
		for(int i=0;i<2;i++){
			Menu menu = new Menu();
			menu.setName("NAME"+i);
			for(int j=0;j<5;j++){
				MenuItem item = new MenuItem();
				item.setName("ITEM"+j);
				item.setHref("#");
				menu.getItems().add(item);
			}
			menus.add(menu);
		}
		dataModel.put("menus", menus);
		
		JspWriter out = getJspContext().getOut();
		
		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		ClassPathResource resource = new ClassPathResource("freemarker/template");
		config.setDirectoryForTemplateLoading(resource.getFile());
		Template template = config.getTemplate("subNavigationTag.ftl");
		try {
			template.process(dataModel, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new  JspException(e);
		}
	  }
}
