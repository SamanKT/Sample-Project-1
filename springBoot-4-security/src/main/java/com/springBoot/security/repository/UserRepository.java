package com.springBoot.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.security.model.UserClass;

public interface UserRepository extends JpaRepository<UserClass, Long>{

	List<UserClass> findByEmail(String email);
	
	
}
