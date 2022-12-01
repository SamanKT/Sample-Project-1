package com.springBoot.one.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.one.api.Employee;
import com.springBoot.one.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {   //ResponseEntity is useful to get details of the http response **RequestBody is used to 
		//retrieve the request body and convert it to java object
		
		return new ResponseEntity<Employee>(service.saveEmployee(employee), HttpStatus.CREATED);
	}
	
	@GetMapping
	public List<Employee> getAllEmp() {
		
		return service.getAll();
	}
	
	@GetMapping("/{id}")
	public Employee getById(@PathVariable("id") long empId) {
		
		return service.getById(empId);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Employee> update(@PathVariable("id") Long id, @RequestBody Employee employee) {
		
		return new ResponseEntity<Employee>(service.update(employee, id), HttpStatus.OK);
		
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteEmp(@PathVariable("id") long id) {
		
		service.deleteEmployee(id);
		return new ResponseEntity<String>("the employee is successfully deleted!", HttpStatus.OK);
	}
}
