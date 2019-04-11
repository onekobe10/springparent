package com.gankki.data.aspect.main;

import com.gankki.data.aspect.MyAspect;
import com.gankki.data.aspect.MyAspect1;
import com.gankki.data.aspect.MyAspect2;
import com.gankki.data.aspect.MyAspect3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

//指定扫描包
@EnableAspectJAutoProxy
@SpringBootApplication(scanBasePackages = {"com.gankki.data.aspect.**"})
public class Chapter4Application {

	// 启动切面
	public static void main(String[] args) {
		SpringApplication.run(Chapter4Application.class, args);
	}

	// 定义切面
	@Bean(name = "myAspect")
	public MyAspect initMyAspect() {
		return new MyAspect();
	}

	// 定义切面
	@Bean(name = "myAspect2")
	public MyAspect2 initMyAspect2() {
		return new MyAspect2();
	}

	// 定义切面
	@Bean(name = "myAspect1")
	public MyAspect1 initMyAspect1() {
		return new MyAspect1();
	}

	// 定义切面
	@Bean(name = "myAspect3")
	public MyAspect3 initMyAspect3() {
		return new MyAspect3();
	}
}
