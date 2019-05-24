package com.gankki.data.gankki.service.impl;

import com.gankki.data.gankki.entity.MySQLBean;
import com.gankki.data.gankki.repository.MySQLRepository;
import com.gankki.data.gankki.service.MySQLService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class MySQLServiceImpl implements MySQLService {

	@Autowired
	private MySQLRepository mySQLRepository;

	@Override
	public void save(MySQLBean mySQLBean) {
		this.mySQLRepository.save(mySQLBean);
	}

	@Override
	public void select() {
		System.out.println("hello world");
	}
}
