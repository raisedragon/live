package com.raise.live.core.command.context;

import java.util.HashMap;
import java.util.Map;

import com.raise.live.core.command.interceptor.Session;
import com.raise.live.core.command.interceptor.SessionFactory;
import com.raise.live.core.exception.LiveException;


public class CommandContext {
	private Map<Class<?>, Session> sessions = new HashMap<Class<?>, Session>();
	private Map<Class<?>,SessionFactory> sessionFactories = new HashMap<Class<?>, SessionFactory>();
	
	@SuppressWarnings({"unchecked"})
	  public <T> T getSession(Class<T> sessionClass) {
	    Session session = sessions.get(sessionClass);
	    if (session == null) {
	      SessionFactory sessionFactory = sessionFactories.get(sessionClass);
	      if (sessionFactory==null) {
	        throw new LiveException("no session factory configured for "+sessionClass.getName());
	      }
	      session = sessionFactory.openSession();
	      sessions.put(sessionClass, session);
	    }

	    return (T) session;
	  }
}
