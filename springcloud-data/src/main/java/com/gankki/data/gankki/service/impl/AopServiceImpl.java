package com.gankki.data.gankki.service.impl;

import com.gankki.data.gankki.service.AopService;
import org.springframework.stereotype.Service;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/5/24
 */
@Service
public class AopServiceImpl implements AopService {

	@Override
	public Object aoptest() {
		return "Hello World Gankki";
	}
}
