package com.springBoot.one.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springBoot.one.api.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

	
}
