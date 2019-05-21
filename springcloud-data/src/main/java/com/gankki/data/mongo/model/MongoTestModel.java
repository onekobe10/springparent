package com.gankki.data.mongo.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serializable;

@ApiModel("mongo测试表")
@Data
@Document(collection = "mongotest")
public class MongoTestModel implements Serializable {

	private static final long serialVersionUID = -6805219975026198353L;

	@Id
	@ApiModelProperty(value="主键")
	private ObjectId id;
	@ApiModelProperty(value="用户名称")
	private String username;
	@ApiModelProperty("用户密码")
	private String password;
	
}
