package com.raise.general.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DirectJspController {
	@RequestMapping("direct/**")
	public ModelAndView direct(HttpServletRequest request,HttpServletResponse response){
		
		String uri = request.getRequestURI();
		
		String contextPath = request.getContextPath();
		String prefix = contextPath+"/direct";
		String viewName = uri.substring(prefix.length(), uri.lastIndexOf("."));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName(viewName);
		return mv;
	}
}
