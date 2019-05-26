package com.gankki.data.gankki.repository;

import com.gankki.data.gankki.entity.MySQLBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MySQLRepository extends JpaRepository<MySQLBean, Integer> {

	List<MySQLBean> findByCnWord1(String name);
}
