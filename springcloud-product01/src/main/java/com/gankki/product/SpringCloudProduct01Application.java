package com.gankki.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 *@desc 服务生产者01
 *@author liuhao
 *@createDate 2019/2/23
 */
@EnableFeignClients
@SpringBootApplication
@EnableCircuitBreaker
public class SpringCloudProduct01Application {

	/**
	 * 初始化RestTemplate 节点负载均衡
	 */
	@LoadBalanced
	@Bean(name = "restTemplate")
	public RestTemplate initRestTemplate() {
		return new RestTemplate();
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProduct01Application.class, args);
	}
}
