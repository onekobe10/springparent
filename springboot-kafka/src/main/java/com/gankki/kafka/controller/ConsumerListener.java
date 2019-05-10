package com.gankki.kafka.controller;

import com.gankki.kafka.entity.User;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
@Component
public class ConsumerListener {

	@KafkaListener(topics = "testTopic")
	public void onMessage(String message){
		//insertIntoDb(buffer);//这里为插入数据库代码
		System.out.println(message);
	}

	@KafkaListener(topics = "userTopic")
	public void onMessage(User user){
		//insertIntoDb(buffer);//这里为插入数据库代码
		System.out.println(user);
	}

}
