package com.gankki.kafka.serializer;

import com.gankki.kafka.entity.User;
import org.apache.kafka.common.serialization.Serializer;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Map;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/9
 */
public class UserSerializable implements Serializer<User> {
	@Override
	public void configure(Map<String, ?> map, boolean b) {

	}

	@Override
	public byte[] serialize(String topic, User user) {
		System.out.println("topic : " + topic + ", user : " + user);
		byte[] dataArray = null;
		ByteArrayOutputStream outputStream = null;
		ObjectOutputStream objectOutputStream = null;
		try {
			outputStream = new ByteArrayOutputStream();
			objectOutputStream = new ObjectOutputStream(outputStream);
			objectOutputStream.writeObject(user);
			dataArray = outputStream.toByteArray();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			if(outputStream != null){
				try {
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if(objectOutputStream != null){
				try {
					objectOutputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return dataArray;
	}

	@Override
	public void close() {

	}
}
