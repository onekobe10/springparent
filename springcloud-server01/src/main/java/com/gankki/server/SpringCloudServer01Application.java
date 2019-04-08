package com.gankki.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 *@desc 服务注册中心01
 *@author liuhao
 *@createDate 2019/2/23
 */
@SpringBootApplication
@EnableEurekaServer
public class SpringCloudServer01Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudServer01Application.class, args);
	}
}
