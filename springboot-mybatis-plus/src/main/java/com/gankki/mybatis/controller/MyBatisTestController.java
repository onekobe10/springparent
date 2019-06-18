package com.gankki.mybatis.controller;

import com.gankki.mybatis.service.MyBatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */

@RequestMapping("mybatis")
@RestController
public class MyBatisTestController {

	@Autowired
	MyBatisTestService myBatisTestService;

	@RequestMapping("testMethod1")
	public Object testMethod1(){
		return myBatisTestService.testMethod1();
	}

	@RequestMapping("testMethod2")
	public Object testMethod2(){
		return myBatisTestService.testMethod2();
	}

	@RequestMapping("testMethod3")
	public Object testMethod3(){
		return myBatisTestService.testMethod3();
	}

	@RequestMapping("testMethod4")
	public Object testMethod4(){
		return myBatisTestService.testMethod4();
	}

	@RequestMapping("testMethod5")
	public Object testMethod5(){
		return myBatisTestService.testMethod5();
	}

}
