package com.gankki.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *@desc 持久层框架测试
 *@author liuhao
 *@createDate 2019/3/24
 */
@SpringBootApplication
@EnableSwagger2
public class SpringCloudDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDataApplication.class, args);
	}
}
