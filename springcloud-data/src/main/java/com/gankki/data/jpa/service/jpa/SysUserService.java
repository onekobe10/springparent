package com.gankki.data.jpa.service.jpa;


import com.gankki.data.jpa.entity.SysUser;
import com.gankki.data.jpa.entity.User;
import com.gankki.data.jpa.entity.User4Jpa;

import java.util.List;

public interface SysUserService {
	SysUser findUserById(Integer id);

	void save(User user);

	List<User> findAll();

	List<User4Jpa> testCustomMethod1();

	List<User4Jpa> testCustomMethod2();

	List<User4Jpa> testCustomMethod3();
}
