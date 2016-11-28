package com.noXml.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class User {
	@Test
	public void test(){
		ApplicationContext ac =new AnnotationConfigApplicationContext(MyConfiguration.class);		
		Car c=ac.getBean(Car.class);
		long time = c.getTime();
		System.out.println(c.getCheel()+":"+time);
	}
}

