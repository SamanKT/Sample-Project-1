package com.springBoot.one.service;

import java.util.List;

import com.springBoot.one.api.Employee;

public interface EmployeeService {

	Employee saveEmployee(Employee employee);
	List<Employee> getAll();
	Employee getById(long id);
	Employee update(Employee emp, Long id);
	void deleteEmployee(long id);
	
}
