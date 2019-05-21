package com.gankki.kafka.controller;

import com.gankki.kafka.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
@RestController
public class KafkaController {

	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;

	@GetMapping("/message/send")
	public boolean send(@RequestParam String message){
		System.out.println("send....." + message);
		kafkaTemplate.send("testTopic",message);
		return true;
	}

	@PostMapping("/user/save")
	public boolean saveUser(@RequestBody User user){
		kafkaTemplate.send("userTopic",user);
		return true;
	}

}
