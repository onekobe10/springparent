package com.gankki.data.controller.valuetest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/2
 */
@RestController
@RequestMapping("/test")
public class ValueTestController {

	@Value("${gankki3}")
	private String test1;
	@Value("${test2}")
	private String test2;
	@Value("#{ systemProperties['user.name'] }")
	private String defaultLocale;
	@Value("#{systemProperties['pop3.port'] ?: 25}")
	private String defaultLocale2;
	@Value("#{ T(java.lang.Math).random() * 100.0 }")
	private String defaultLocale3;
	@Value("#{new Integer(1).intValue()}")
	private Integer testInteger;
	@Value("#{'Hello World'.bytes.length}")
	private Integer strLength;
	@Value("#{'${gankki3}'.split(',')}")
	private List<String> list;

	@RequestMapping("/testConfig1")
	public String testConfig(){
		return test1;
	}
	@RequestMapping("/testConfig2")
	public String testConfig2(){
		return test2;
	}
	@RequestMapping("/testConfig3")
	public String testConfig3(){
		return defaultLocale;
	}
	@RequestMapping("/testConfig4")
	public String testConfig4(){
		return defaultLocale2;
	}
	@RequestMapping("/testConfig5")
	public String testConfig5(){
		return defaultLocale3;
	}
	@RequestMapping("/testConfig6")
	public Integer testConfig6(){
		return testInteger;
	}
	@RequestMapping("/testConfig7")
	public Integer testConfig7(){
		return strLength;
	}
	@RequestMapping("/testConfig8")
	public Object testConfig8(){
		return list;
	}
}
