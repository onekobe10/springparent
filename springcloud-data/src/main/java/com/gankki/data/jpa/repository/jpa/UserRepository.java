package com.gankki.data.jpa.repository.jpa;

import com.gankki.data.jpa.entity.SysUser;
import com.gankki.data.jpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	SysUser save(Integer id);
}
