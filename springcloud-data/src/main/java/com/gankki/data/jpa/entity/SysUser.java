package com.gankki.data.jpa.entity;


import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity(name = "sys_user")
public class SysUser implements Serializable {

	private static final long serialVersionUID = 8397089698106324894L;

	@Id
	@Column(name = "id", unique = true, nullable = false, columnDefinition = "int(11) COMMENT '主键'")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "username", columnDefinition = "varchar(255) COMMENT '用户名称'")
	private String username;
	@Column(name = "password", columnDefinition = "varchar(255) COMMENT '密码'")
	private String password;
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "f_id", foreignKey = @ForeignKey(name = "f_id", value = ConstraintMode.CONSTRAINT))
	private Set<SysRole> sysRoleSet;
    /*@OneToMany
    @JoinTable(name = "sys_role_user", joinColumns = @JoinColumn(name = "userid", referencedColumnName = "id")
            , inverseJoinColumns = @JoinColumn(name = "roleid", referencedColumnName = "id"))
    private Set<SysRole> sysRoleSet;*/
}
