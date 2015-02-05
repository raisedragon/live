package com.raise.orgs.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.raise.orgs.IdentityService;

@Controller
@RequestMapping("/")
public class HoneController {
	IdentityService identityService;


	@RequestMapping("index")
	public ModelAndView save(HttpServletRequest request,HttpServletResponse response){
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}
