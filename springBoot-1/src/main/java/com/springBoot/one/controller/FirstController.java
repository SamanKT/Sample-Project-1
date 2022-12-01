package com.springBoot.one.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springBoot.one.api.Student;

@RestController
public class FirstController {

	@GetMapping("/")
	public String hello() {
		
		return "Hello Spring Boot!";
	}
	
	
	@GetMapping(value="/student"  )
	public Student student() {
		
		return new Student("joe", "james");
	}
	
	
	@GetMapping("/student/{firstName}/{secondName}")
	public List<Student> students(@PathVariable("firstName") String firstName, @PathVariable("secondName") String secondName ) {
		
		List<Student> students = new ArrayList();
		
		students.add(new Student(firstName,secondName));
		students.add(new Student(secondName, firstName));
		
		return students; 
		
		
	}
	
	
	@GetMapping("/student/query")
	public Student studentQuery(@RequestParam("first") String firstName,
			@RequestParam("second") String secondName) {
		
		return new Student(firstName, secondName );
	}
	
}
