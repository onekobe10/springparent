package com.gankki.data.mongo.service.impl;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.gankki.data.mongo.model.MongoTestModel;
import com.gankki.data.mongo.service.MongoTestService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class MongoTestServiceImpl implements MongoTestService {

	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public Object mongoTest(String name) {
		MongoTestModel mongoTestModel = new MongoTestModel();
		mongoTestModel.setId(new ObjectId());
		mongoTestModel.setUsername("gankki");
		mongoTestModel.setPassword("123");
		this.mongoTemplate.save(mongoTestModel);
		return "123";
	}

	@Override
	public Object mongoGet(String name) {
		String command = "{find: \"mongotest\",\n" +
				" filter:{username:\"gankki\"}\n" +
				" }";
		return this.mongoTemplate.executeCommand(command);
	}

}
