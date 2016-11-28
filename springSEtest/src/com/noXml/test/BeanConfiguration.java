package com.noXml.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration{
	@Bean
	public Car car(){return new Car("aa","bb");}
	
}
