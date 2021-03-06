package com.gankki.data.jpa.service.impl.jpa;

import com.gankki.data.jpa.entity.User4Jpa;
import com.gankki.data.jpa.repository.jpa.SysUserRepository;
import com.gankki.data.jpa.repository.jpa.UserRepository;
import com.gankki.data.jpa.entity.SysUser;
import com.gankki.data.jpa.entity.User;
import com.gankki.data.jpa.service.jpa.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl implements SysUserService {

	@Autowired
	private SysUserRepository sysUserRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public SysUser findUserById(Integer id) {
		return this.sysUserRepository.findUserById(id);
	}

	@Override
	public void save(User user) {
		this.userRepository.save(user);
	}

	@Override
	public List<User> findAll() {
		return this.userRepository.findAll();
	}

	@Override
	public List<User4Jpa> testCustomMethod1() {
		return this.userRepository.testCustomMethod1();
	}

	@Override
	public List<User4Jpa> testCustomMethod2() {
		return this.userRepository.testCustomMethod2();
	}

	@Override
	public List<User4Jpa> testCustomMethod3() {
		return this.userRepository.testCustomMethod3();
	}
}
