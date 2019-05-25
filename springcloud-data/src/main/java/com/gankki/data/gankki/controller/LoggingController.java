package com.gankki.data.gankki.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/25
 */
@RestController
@Slf4j
public class LoggingController {

	@RequestMapping("/test/logging")
	public String testLogging(){
		log.trace("trace");

		if (log.isDebugEnabled()) {
			log.debug("debug");
		}

		log.info("info");
		log.info("hello {}, this is the {}, welcome to {}!","gankki", "world", "tokyo");

		log.warn("warn");

		log.error("error");
		log.error("测试错误输出", new RuntimeException("测试错误输出"));
		return "hello, gankki";
	}
}
