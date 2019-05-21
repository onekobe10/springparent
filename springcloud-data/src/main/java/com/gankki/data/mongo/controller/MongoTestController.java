package com.gankki.data.mongo.controller;

import com.gankki.data.mongo.service.MongoTestService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(value="/mongo",tags="mongo测试")
public class MongoTestController {

	@Autowired
	private MongoTestService mongoTestService;


	@ApiOperation(value = "Mongo测试", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping(value = "/test")
	public Object mongoTest(@ApiParam("用户名称") String name){
		return this.mongoTestService.mongoTest(name);
	}

	@ApiOperation(value = "Mongo查询", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
	@PostMapping(value = "/get")
	public Object mongoGet(@ApiParam("用户名称") String name){
		return this.mongoTestService.mongoGet(name);
	}


}
