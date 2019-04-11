package com.gankki.data.jpa.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "sys_role")
public class SysRole {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "int(11) COMMENT '主键'")
	private Integer id;
	@Column(name = "rolename", columnDefinition = "varchar(255) COMMENT '角色名称2'")
	private String rolename;
}
