package com.gankki.mybatis.service;

import com.gankki.mybatis.mapper.TblDepartmentMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
@Service
public class MyBatisTest2Service {


	@Resource
	private TblDepartmentMapper tblDepartmentMapper;

	public List<String> selectById() {
		return tblDepartmentMapper.selectById1();
	}



	@Async
	@Transactional(propagation = Propagation.SUPPORTS, rollbackFor = Exception.class)
	public void insert2() throws Exception{
		System.out.println("insert2...." + Thread.currentThread().getName());
		tblDepartmentMapper.insert1(1003L, new Date());
		throw new Exception("hah2");
	}



}
