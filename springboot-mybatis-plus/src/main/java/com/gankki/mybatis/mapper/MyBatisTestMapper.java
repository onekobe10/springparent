package com.gankki.mybatis.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gankki.mybatis.entity.TestMybatis;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liuhao
 * @desc
 * @createDate 2019/6/17
 */
@Mapper
public interface MyBatisTestMapper extends BaseMapper<TestMybatis> {

	List<TestMybatis> selectByPage(Page page, @Param("password") String password);

}
