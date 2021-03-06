package com.gankki.bean;

import com.alibaba.fastjson.JSON;
import com.gankki.bo.PropertiesTest2BO;
import com.gankki.bo.PropertiesTestBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
public class ConfigurationTest {
	/*@Bean(value = "hellowordgankki1")
	public BeanConfig sayBeanConfig () {
		log.info("注入BeanConfig...bean");
		return new BeanConfig();
	}*/

	@Bean(value = "hellowordgankki")
	public HelloWorld sayHello () {
		log.info("Configuration--Bean");
		return new HelloWorld();
	}

	@Bean("foo")
	@ConfigurationProperties("foo.datasource")
	public PropertiesTestBO createFooBO() {
		return  new PropertiesTestBO();
	}

	/*@Bean("sar")
	public PropertiesTest2BO createSarBO() {
		return  new PropertiesTest2BO();
	}*/

}
