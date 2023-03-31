package com.gankki.mybatis.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gankki.mybatis.entity.TestMybatis;
import com.gankki.mybatis.mapper.MyBatisTestMapper;
import com.gankki.mybatis.mapper.TblDepartmentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/6/17
 */
@Service
public class MyBatisTestService {

	@Autowired
	private MyBatisTestMapper myBatisTestMapper;

	@Resource
	private TblDepartmentMapper tblDepartmentMapper;

	@Resource
	private MyBatisTest2Service myBatisTest2Service;

	public List<String> selectById() {
		return tblDepartmentMapper.selectById1();
	}

	@Transactional(rollbackFor = Exception.class)
	public void insert1() throws Exception {
		tblDepartmentMapper.insert1(1002L, new Date());
		System.out.println("insert1...." + Thread.currentThread().getName());
		myBatisTest2Service.insert2();
		//CompletableFuture.runAsync(() -> insert2());
		throw new Exception("hah");
	}

	public TestMybatis testMethod1() {
		return myBatisTestMapper.selectById(1);
	}

	public List<TestMybatis> testMethod2() {
		Page page = new Page();
		page.setCurrent(2);
		page.setSize(2);
		return myBatisTestMapper.selectByPage(page, "123456");
	}

	/**
	 * 如果返回多条数据，会报错
	 * @return
	 */
	public TestMybatis testMethod3() {
		QueryWrapper<TestMybatis> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("id", "1");
		return myBatisTestMapper.selectOne(queryWrapper);
	}

	public List<TestMybatis> testMethod4() {
		QueryWrapper<TestMybatis> queryWrapper = new QueryWrapper<>();
		queryWrapper.eq("password", "123456");
		return myBatisTestMapper.selectList(queryWrapper);
	}

	/**
	 * 只能相等判断
	 * @return
	 */
	public List<TestMybatis> testMethod5() {
		Map<String, Object> map = new HashMap<>(1);
		map.put("password", "123456");
		return myBatisTestMapper.selectByMap(map);
	}

}
