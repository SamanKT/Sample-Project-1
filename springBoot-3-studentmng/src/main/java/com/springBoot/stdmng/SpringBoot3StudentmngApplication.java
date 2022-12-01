package com.springBoot.stdmng;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.springBoot.stdmng.entity.Student;
import com.springBoot.stdmng.repository.StudentRepository;

@SpringBootApplication
public class SpringBoot3StudentmngApplication implements CommandLineRunner {

	@Autowired
	private StudentRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBoot3StudentmngApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		Student s1 = new Student("Joe", "Free", "joe@gmail.com");
//		Student s2 = new Student("Karim", "Mira", "mira@gmail.com");
//		Student s3 = new Student("Fred", "Stone", "fred@gmail.com");
//		
//		List<Student> students = new ArrayList<>();
//		students.add(s1); students.add(s2); students.add(s3);
//		if (repository.count()==0) repository.saveAll(students);
	}

}
