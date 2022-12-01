package com.springBoot.security.dto;

import java.util.Set;

import com.springBoot.security.model.RoleClass;

public class UserDto {

	private String name;

	private String lastName;

	private String email;

	private String password;

	private Set<RoleClass> roles;

	public UserDto() {
	}
	
	public UserDto(String name, String lastName, String email, String password, Set<RoleClass> roles) {
		this.name = name;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.roles = roles;
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



	public Set<RoleClass> getRoles() {
		return roles;
	}



	public void setRoles(Set<RoleClass> roles) {
		this.roles = roles;
	}

	

}
