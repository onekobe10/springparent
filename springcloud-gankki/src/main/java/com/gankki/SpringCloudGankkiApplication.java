package com.gankki;


import org.springframework.beans.factory.BeanNameAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 *@desc Gankki的专用测试
 *@author liuhao
 *@createDate 2019/3/1
 */
@EnableAsync
@SpringBootApplication
public class SpringCloudGankkiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudGankkiApplication.class, args);
	}

}
