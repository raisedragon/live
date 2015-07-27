package com.raise.quartz.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.gdcc.core.controller.BaseController;


@Controller
@RequestMapping("schedule")
public class ScheduleController extends BaseController {
	
	@RequestMapping("list")
	public ModelAndView list(HttpServletRequest request,HttpServletResponse response){
		
		ModelAndView mv = getDefaultModelAndView(request);
		return mv;
	}
}
