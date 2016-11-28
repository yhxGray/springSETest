package com.noXml.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({BeanConfiguration.class})
public class MyConfiguration {

	@Bean
	public Man man(){
		return new Man();
	}
}
