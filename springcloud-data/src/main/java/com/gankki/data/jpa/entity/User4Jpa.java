package com.gankki.data.jpa.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 *@desc jpa 练习使用user
 *@author liuhao
 *@createDate 2019/4/22
 */
@Data
@Entity
@Table(name = "j_user")
public class User4Jpa implements Serializable {

	private static final long serialVersionUID = 1537762257879435644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "username")
	private String username;
}