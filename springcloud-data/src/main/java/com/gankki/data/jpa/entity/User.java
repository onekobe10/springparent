package com.gankki.data.jpa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Data
@Entity
@Table(name = "t_user")
public class User implements Serializable {

	private static final long serialVersionUID = 1537762257879435644L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Integer userId;
	@Column(name = "username")
	private String username;
	@ManyToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinTable(
			name = "user_role",
			joinColumns = {@JoinColumn(name = "user_id")},
			inverseJoinColumns = {@JoinColumn(name = "role_id")}
	)
	@JsonIgnoreProperties(value = {"users"})
	private Set<Role> roles;
}