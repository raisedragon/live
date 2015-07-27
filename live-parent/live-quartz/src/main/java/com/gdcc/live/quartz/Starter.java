package com.gdcc.live.quartz;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Starter {
	public static void main(String[] args) {
		String[] locations = new String[] { "classpath:/conf/spring/context.xml" };
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext(locations);
		while(true){
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
