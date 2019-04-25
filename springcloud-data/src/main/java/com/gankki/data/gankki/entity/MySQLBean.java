package com.gankki.data.gankki.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@desc
 *@author liuhao
 *@createDate 2019/4/23
 */
@Data
@Entity
@Table(name = "mysql_test")
public class MySQLBean implements Serializable {

	private static final long serialVersionUID = -675160488098174105L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id", unique=true, nullable=false, columnDefinition = "int(11) COMMENT '主键'")
	private Integer id;
	@Column(name = "cn_word1", columnDefinition = "varchar(255) COMMENT '中文1'")
	private String cnWord1;
	@Column(name = "cn_word2", columnDefinition = "varchar(255) COMMENT '中文2'")
	private String cnWord2;
	@Column(name = "uuid1", columnDefinition = "varchar(255) COMMENT 'uuid1'")
	private String uuid1;
	@Column(name = "uuid2", columnDefinition = "varchar(255) COMMENT 'uuid2'")
	private String uuid2;
	@Column(name = "intTest", columnDefinition = "int(11) COMMENT '整型测试'")
	private Integer intTest;

}
