package com.gankki.data.jpa.controller;

import com.gankki.data.jpa.service.jpa.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/22
 */
@RestController
@RequestMapping("/user")
public class UserTestController {

	@Autowired
	SysUserService sysUserService;

	@RequestMapping("/testCustomMethod1")
	public Object testCustomMethod1(){
		return this.sysUserService.testCustomMethod1();
	}

	@RequestMapping("/testCustomMethod2")
	public Object testCustomMethod2(){
		return this.sysUserService.testCustomMethod2();
	}

	@RequestMapping("/testCustomMethod3")
	public Object testCustomMethod3(){
		return this.sysUserService.testCustomMethod3();
	}
}
