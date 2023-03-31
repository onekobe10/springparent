package com.gankki.mybatis.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * @author liuhao
 * @desc
 * @createDate 2019/6/17
 */
@Mapper
public interface TblDepartmentMapper{

	List<String> selectById1();

	Long insert1(@Param("customerId") Long customerId, @Param("createTime") Date createTime);

}
