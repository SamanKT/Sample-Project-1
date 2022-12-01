package com.springBoot.one.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.one.api.Employee;
import com.springBoot.one.exception.EmployeeException;
import com.springBoot.one.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Override
	public Employee saveEmployee(Employee employee) {
		
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAll() {
		
		return employeeRepository.findAll();
	}

	@Override
	public Employee getById(long id) {
		
//		Optional<Employee> findById = employeeRepository.findById(id);
//		if (findById.isPresent()) return findById.get();
//		else throw new EmployeeException("Employee", "Id", id);
		
		return employeeRepository.findById(id).orElseThrow(() ->  new EmployeeException("Employee", "Id", id)); //using lambda approach
		
	}

	@Override
	public Employee update(Employee emp, Long id) {
		Employee employee = employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee", "Id", id));
		employee.setName(emp.getName());
		employee.setId(emp.getId());
		employee.setLastName(emp.getLastName());
		employee.setEmail(emp.getEmail());
		employeeRepository.save(employee);
		return employee;
	}

	@Override
	public void deleteEmployee(long id) {

		employeeRepository.findById(id).orElseThrow(() -> new EmployeeException("Employee", "Id", id));
		
		employeeRepository.deleteById(id);
	}

	
	
}
