package com.springBoot.security.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class UserClass {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column
	private String name;
	@Column(name =  "lastname")
	private String lastName;
	
	@Column(name = "email", unique = true)
	private String email;
	
	private String password;
	
	@ManyToMany (fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable( name = "userrole",
	joinColumns = @JoinColumn(name="userside" ),
	inverseJoinColumns = @JoinColumn(name="roleside")
			)
	private
	Set<RoleClass> takenRoles = new HashSet<>();

	
	public UserClass() {};
	
	public UserClass(String name, String lastName, String email, String password) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<RoleClass> getTakenRoles() {
		return takenRoles;
	}

	public void setTakenRoles(Set<RoleClass> takenRoles) {
		this.takenRoles = takenRoles;
	}

	
	
	
	
	
}
