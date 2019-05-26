package com.gankki.data.gankki.service;

import com.gankki.data.gankki.entity.MySQLBean;

import java.util.List;

public interface MySQLService {
	void save(MySQLBean mySQLBean);

	void select();

	List<MySQLBean> findByCnWord1(String name);
}
