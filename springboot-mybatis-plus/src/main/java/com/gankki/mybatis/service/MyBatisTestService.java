package com.gankki.mybatis.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gankki.mybatis.entity.TestMybatis;
import com.gankki.mybatis.mapper.MyBatisTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
@Service
public class MyBatisTestService {

	@Autowired
	private MyBatisTestMapper myBatisTestMapper;

	public TestMybatis testMethod1() {
		return myBatisTestMapper.selectById(1);
	}

	public List<TestMybatis> testMethod2() {
		Page page = new Page();
		page.setCurrent(2);
		page.setSize(2);
		return myBatisTestMapper.selectByPage(page, "123456");
	}
}
