package com.gankki.data.jpa.entity;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

@Data
@Entity(name = "record")
@Alias("purchaseRecord")
public class PurchaseRecordPo implements Serializable {
	private static final long serialVersionUID = -360816189433370174L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "int(11) COMMENT '编号'")
	private Long id;
	@Column(name = "userId", columnDefinition = "int(11) COMMENT '用户Id'")
	private Long userId;
	@Column(name = "productId", columnDefinition = "int(11) COMMENT '产品Id'")
	private Long productId;
	@Column(name = "price", columnDefinition = "double(10,2) COMMENT '产品价格'")
	private double price;
	@Column(name = "quantity", columnDefinition = "int(11) COMMENT '数量'")
	private int quantity;
	@Column(name = "sum", columnDefinition = "double(10,2) COMMENT '总价'")
	private double sum;
	@Column(name = "purchaseTime", columnDefinition = "timestamp COMMENT '购买日期'")
	private Timestamp purchaseTime;
	@Column(name = "note", columnDefinition = "varchar(255) COMMENT '备注'")
	private String note;

}