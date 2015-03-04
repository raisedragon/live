package com.gdcc.live.core.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import com.gdcc.live.core.dao.Dao;
import com.gdcc.live.core.exception.LiveException;
import com.gdcc.live.core.manager.Manager;

@Component
public class AppContext implements ApplicationContextAware {
	
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	/**
	 * 根据类从spring上下文获取bean。
	 * 
	 * @param cls
	 * @return
	 */
	public <T> T getBean(Class<T> cls) {

		T bean = applicationContext.getBean(cls);
		if (bean == null) {
			throw new LiveException("Bean of class " + cls.getName()
					+ " not found");
		}
		return bean;
	}

	public <T extends Dao<?, ?>> T getDao(Class<T> cls) {
		return this.getBean(cls);
	}

	public <T extends Manager<?, ?>> T getManager(Class<T> cls) {
		return this.getBean(cls);
	}

}
