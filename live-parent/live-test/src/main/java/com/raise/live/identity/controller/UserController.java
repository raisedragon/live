package com.raise.live.identity.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;

import com.raise.live.identity.manager.UserManager;

@Controller
public class UserController {
	@Autowired
	private UserManager userManager;
}
