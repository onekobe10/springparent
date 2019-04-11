package com.gankki.data.jpa.service.jpa;


import com.gankki.data.jpa.entity.SysUser;
import com.gankki.data.jpa.entity.User;

import java.util.List;

public interface SysUserService {
	SysUser findUserById(Integer id);

	void save(User user);

	List<User> findAll();
}
