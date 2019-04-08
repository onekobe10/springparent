package com.gankki.zuul;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 *@desc Zuul网关
 *@author liuhao
 *@createDate 2019/2/23
 */
@SpringBootApplication
@EnableZuulProxy
public class SpringCloudZuulApplication {


	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulApplication.class, args);
	}
}
