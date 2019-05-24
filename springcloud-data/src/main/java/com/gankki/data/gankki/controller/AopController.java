package com.gankki.data.gankki.controller;

import com.gankki.data.gankki.service.AopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/24
 */
@RestController
@RequestMapping("/aop")
public class AopController {

	@Autowired
	private AopService aopService;

	@RequestMapping("/test")
	public Object testAop(){
		return this.aopService.aoptest();
	}
}
