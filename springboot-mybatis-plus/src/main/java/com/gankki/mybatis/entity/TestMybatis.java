package com.gankki.mybatis.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
@Data
@TableName(value = "mybatis_plus")
public class TestMybatis {

	@TableId(type = IdType.AUTO)
	private Integer id;
	private String userName;
	private String password;
	private LocalDateTime createDate;
	private LocalDateTime updateDate;

}