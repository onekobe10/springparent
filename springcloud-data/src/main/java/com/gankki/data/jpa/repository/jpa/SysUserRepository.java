package com.gankki.data.jpa.repository.jpa;

import com.gankki.data.jpa.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Integer> {
	SysUser findUserById(Integer id);
}
