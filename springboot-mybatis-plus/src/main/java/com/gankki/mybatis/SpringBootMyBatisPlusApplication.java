package com.gankki.mybatis;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceAutoConfigure;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
@MapperScan("com.gankki.mybatis.mapper")
@SpringBootApplication(exclude = DruidDataSourceAutoConfigure.class)
public class SpringBootMyBatisPlusApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMyBatisPlusApplication.class, args);
	}
}
