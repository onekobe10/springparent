package com.gankki;


import com.alibaba.fastjson.JSON;
import com.gankki.bo.PropertiesTest1BO;
import com.gankki.bo.PropertiesTest2BO;
import com.gankki.bo.PropertiesTestBO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.sql.DataSource;

/**
 *@desc Gankki的专用测试
 *@author liuhao
 *@createDate 2019/3/1
 */
@Slf4j
@EnableAsync
@SpringBootApplication
@EnableConfigurationProperties(PropertiesTest2BO.class)
/*1.
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		JdbcTemplateAutoConfiguration.class})
		*/
public class SpringCloudGankkiApplication implements CommandLineRunner {
	@Autowired
	ApplicationContext applicationContext;
	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGankkiApplication.class, args);
	}

	@Override
	public void run(String... args) {
		PropertiesTestBO foo = (PropertiesTestBO)applicationContext.getBean("foo");
		PropertiesTest1BO bar = (PropertiesTest1BO)applicationContext.getBean("bar");
		PropertiesTest2BO sar = applicationContext.getBean(PropertiesTest2BO.class);
		log.info("bar:{}", JSON.toJSONString(bar));
		log.info("foo:{}", JSON.toJSONString(foo));
		log.info("sat:{}", JSON.toJSONString(sar));
	}

	/*1.
	@Bean
	@ConfigurationProperties("foo.datasource")
	public DataSourceProperties fooDataSourceProperties() {
		return new DataSourceProperties();
	}

	@Bean
	public DataSource fooDataSource() {
		DataSourceProperties dataSourceProperties = fooDataSourceProperties();
		log.info("foo datasource: {}", dataSourceProperties.getUrl());
		return dataSourceProperties.initializeDataSourceBuilder().build();
	}
	*/

}
