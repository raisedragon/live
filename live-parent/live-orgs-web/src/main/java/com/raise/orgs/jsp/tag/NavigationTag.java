package com.raise.orgs.jsp.tag;

import java.io.IOException;
import java.util.HashMap;
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

import com.raise.orgs.AuthenticateService;
import com.raise.orgs.ProcessEngineConfiguration;
import com.raise.orgs.core.spring.AppUtil;
import com.raise.orgs.identity.User;
import com.raise.orgs.impl.cfg.ProcessEngineConfigurationImpl;
import com.raise.orgs.impl.context.Context;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class NavigationTag extends SimpleTagSupport {
	
	
	public void doTag() throws JspException, IOException {
		User user = Context.getUser();
		Map<String,Object> dataModel = new HashMap<String,Object>();
	
		AuthenticateService authenticateService = AppUtil.getBean(AuthenticateService.class);
		
//		authenticateService.getResource()
		
		Menu menu = new Menu();
		//TODO
		for(int i=0;i<5;i++){
			MenuItem item = new MenuItem();
			item.setName("ITEM"+i);
			item.setHref("#");
			menu.getItems().add(item);
		}
		dataModel.put("menu", menu);
		
		JspWriter out = getJspContext().getOut();
		
		Configuration config = new Configuration(Configuration.DEFAULT_INCOMPATIBLE_IMPROVEMENTS);
		ClassPathResource resource = new ClassPathResource("freemarker/template");
		config.setDirectoryForTemplateLoading(resource.getFile());
		Template template = config.getTemplate("navigationTag.ftl");
		try {
			template.process(dataModel, out);
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new  JspException(e);
		}
	  }
}
