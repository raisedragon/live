package com.raise.orgs.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.raise.orgs.IdentityService;
import com.raise.orgs.identity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	IdentityService identityService;


	@RequestMapping("save")
	public Map<String, Object> save(HttpServletRequest request,
			HttpServletResponse response, User user) {
		Map<String, Object> model = new HashMap<String, Object>();
		identityService.saveUser(user);
		return model;
	}
}
