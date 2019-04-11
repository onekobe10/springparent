package com.gankki.data.jpa.dao;

import com.gankki.data.jpa.entity.ProductPo;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


/**** imports ****/
public interface ProductDao4Jpa extends JpaRepository<ProductPo, Long> {

	public ProductPo getProductById(Long id);


	@Modifying
	@Query("update product set stock = stock - ?2 where id = ?1 ")
	public int decreaseProduct(@Param("id") Long id, @Param("quantity") int quantity);

}