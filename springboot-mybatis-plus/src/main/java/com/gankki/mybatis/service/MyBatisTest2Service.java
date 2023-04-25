package com.gankki.mybatis.service;

import com.gankki.mybatis.mapper.TblDepartmentMapper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	public static void main(String[] args) {
		Map<String, Object> map = new HashMap<>();
		System.out.println((Double) map.getOrDefault("1", null));
	}


}
