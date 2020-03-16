package com.gankki.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HelloWorldConfig {

	@Bean(value = "hellowordgankki")
	public HelloWorld sayHello () {
		System.out.println("注入sayHello...bean");
		return new HelloWorld();
	}

	/*@Bean(value = "hellowordgankki1")
	public BeanConfig sayBeanConfig () {
		System.out.println("注入BeanConfig...bean");
		return new BeanConfig();
	}*/
}
