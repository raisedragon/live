package com.gdcc.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class BaseController {
	
	
	/**
	 * @param request
	 * @return
	 */
	public ModelAndView getDefaultModelAndView(HttpServletRequest request){
		String uri = request.getRequestURI();
		String contextPath = request.getContextPath();
		String prefix = contextPath;
		String viewName = uri.substring(prefix.length(), uri.lastIndexOf("."));
		return new ModelAndView(viewName);
	}
}
