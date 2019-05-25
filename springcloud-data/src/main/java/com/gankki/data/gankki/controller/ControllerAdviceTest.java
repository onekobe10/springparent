package com.gankki.data.gankki.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@desc @ControllerAdvice 练习
 *@author liuhao
 *@createDate 2019/5/24
 */
@RestController
public class ControllerAdviceTest {

	@ApiOperation("测试ControllerAdvice")
	@RequestMapping("/testController")
	public Object testController(){
		throw new RuntimeException("测试ControllerAdvice");
	}
}
