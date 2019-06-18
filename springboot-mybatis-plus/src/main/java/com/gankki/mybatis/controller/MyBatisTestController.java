package com.gankki.mybatis.controller;

import com.gankki.mybatis.entity.TestMybatis;
import com.gankki.mybatis.service.MyBatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
}
