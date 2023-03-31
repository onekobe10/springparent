package com.gankki.mybatis.controller;

import com.gankki.mybatis.entity.TestMybatis;
import com.gankki.mybatis.service.MyBatisTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

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

	@GetMapping("insert1")
	public String insert1()  throws Exception{
		myBatisTestService.insert1();
		return "success";
	}

	@GetMapping("test1")
	public List<String> test1(){
		return myBatisTestService.selectById();
	}


	@RequestMapping("testMethod1")
	public Object testMethod1(){
		TestMybatis testMybatis = myBatisTestService.testMethod1();
		/**
		 * 说明从数据库中查出来的字符串是运行时产生的，需要intern方法才能使用常量池中的字符串
		 * 但是没有必要使用intern方法，因为在请求结束之后，这个对象会很快被GC回收
		 */
		System.out.println("aaaa" == testMybatis.getUserName());
		System.out.println("aaaa" == testMybatis.getUserName().intern());
		return testMybatis;
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
