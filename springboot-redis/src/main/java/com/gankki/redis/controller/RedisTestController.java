package com.gankki.redis.controller;

import com.gankki.redis.service.IRedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("redis")
public class RedisTestController {

	@Autowired
	private IRedisService redisService;

	@RequestMapping("testMethod1")
	public Object testMethod1(){
		//this.redisService.set("liu", "hao");
		return this.redisService.get("liu");
	}
}
