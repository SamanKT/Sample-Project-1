package com.springBoot.security.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.security.model.RoleClass;

public interface RoleRepository extends JpaRepository<RoleClass, Long>{

	RoleClass findByName(String name);
}
