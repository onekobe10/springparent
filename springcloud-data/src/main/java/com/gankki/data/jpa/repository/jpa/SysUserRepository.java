package com.gankki.data.jpa.repository.jpa;

import com.gankki.data.jpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {

	/**
	 * 根据方法名自动生成sql语句
	 * @param id
	 * @return
	 */
	SysUser findUserById(Integer id);
}
