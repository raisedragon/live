package com.gdcc.live.quartz.service;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TestBean {
	public void testMethod(){
		System.out.println(new Date()+"--- Execute--");
	}
}
