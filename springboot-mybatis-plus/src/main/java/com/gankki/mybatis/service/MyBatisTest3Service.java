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
public class MyBatisTest3Service extends MyBatisTestService{


	@Resource
	private TblDepartmentMapper tblDepartmentMapper;




	@Override
	public void insert1() throws Exception {
		tblDepartmentMapper.insert1(1002L, new Date());
		System.out.println("insert1...." + Thread.currentThread().getName());
		throw new RuntimeException("hah");
	}



}
