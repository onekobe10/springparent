package com.gankki.data.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "t_role")
public class Role implements Serializable {

	private static final long serialVersionUID = 5704195230910574295L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Integer roleId;
	@Column(name = "role_name", unique = true)
	private String roleName;
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY, mappedBy = "roles")
	@JsonIgnoreProperties(value = {"roles"})
	private Set<User> users;
}