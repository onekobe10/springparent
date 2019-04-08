package com.gankki.dashboard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 *@desc Hystrix仪表盘
 *@author liuhao
 *@createDate 2019/2/23
 */
@SpringBootApplication
@EnableHystrixDashboard
public class SpringCloudDashBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudDashBoardApplication.class, args);
	}
}
