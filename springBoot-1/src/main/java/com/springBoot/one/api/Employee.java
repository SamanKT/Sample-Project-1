package com.springBoot.one.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity  //to say that this class is an entity to JPA
@Table(name = "employee")    // dont forget to use javax.persistence class
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) //this will generate the IDs in the order of creation
	private long id;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email", nullable = false)
	private String email;
}
