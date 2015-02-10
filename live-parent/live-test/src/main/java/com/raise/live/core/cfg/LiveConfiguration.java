package com.raise.live.core.cfg;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.raise.live.core.command.interceptor.Session;
import com.raise.live.core.command.interceptor.SessionFactory;
import com.raise.live.core.persistence.GenericManagerFactory;

public class LiveConfiguration implements ApplicationContextAware {
	protected ApplicationContext applicationContext;
	
	
	protected void init(){
	}

	
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
	
}
