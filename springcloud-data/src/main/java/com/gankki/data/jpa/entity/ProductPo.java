package com.gankki.data.jpa.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.OptimisticLockType;
import org.hibernate.annotations.OptimisticLocking;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity(name = "product")
@Alias("product")
@OptimisticLocking(type = OptimisticLockType.DIRTY)
@DynamicUpdate(value = true)
public class ProductPo implements Serializable {
	private static final long serialVersionUID = 3288311147760635602L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "int(11) COMMENT '编号'")
	private Long id;
	@Column(name = "productName", columnDefinition = "varchar(255) COMMENT '产品名称'")
	private String productName;
	@Column(name = "stock", columnDefinition = "int(11) COMMENT '库存'")
	private int stock;
	//@Version
	@Column(name = "version", nullable = false, columnDefinition = "int(11) default 0 COMMENT '版本号'")
	private int version;
	@Column(name = "price", columnDefinition = "double(10,2) COMMENT '单价'")
	private double price;
	@Column(name = "note", columnDefinition = "varchar(255) COMMENT '备注'")
	private String note;
}