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
	protected ApplicationContext springContext;
	protected Map<Class<?>,SessionFactory> sessionFactories;
	
	
	protected void init(){
		initSessionFactories();
	}

	protected void initSessionFactories(){
		Map<String,SessionFactory> factories = springContext.getBeansOfType(SessionFactory.class);
		for(SessionFactory sessionFactory: factories.values()){
			sessionFactories.put(sessionFactory.getSessionType(), sessionFactory);
		}
		Map<String,Session> sessions = springContext.getBeansOfType(Session.class);
		for(Session session:sessions.values()){
			if(!sessionFactories.containsKey(session.getClass())){
				sessionFactories.put(session.getClass(), new GenericManagerFactory(session.getClass()));
			}
		}
		
	}
	
	public void setApplicationContext(ApplicationContext springContext)
			throws BeansException {
		this.springContext = springContext;
	}
	
}
