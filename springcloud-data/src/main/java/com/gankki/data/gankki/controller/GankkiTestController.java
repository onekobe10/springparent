package com.gankki.data.gankki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@desc Special for Gankki with test
 *@author liuhao
 *@createDate 2019/4/16
 */
@RestController
@RequestMapping("/gankki")
public class GankkiTestController {
	@Value("${testdev}")
	private String test1;
	@Value("${testprofie}")
	private String test2;

	@RequestMapping("/testConfig1")
	public String testConfig(){
		return test1 + "---" + test2 + "---";
	}
}
