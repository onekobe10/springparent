package com.gankki.data.jpa.repository.jpa;

import com.gankki.data.jpa.entity.SysUser;
import com.gankki.data.jpa.entity.User;
import com.gankki.data.jpa.entity.User4Jpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	SysUser save(Integer id);

	List<User4Jpa> testCustomMethod1();

	List<User4Jpa> testCustomMethod2();

	List<User4Jpa> testCustomMethod3();
}
