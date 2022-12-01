package com.springBoot.stdmng.service;

import java.util.List;

import com.springBoot.stdmng.entity.Student;

public interface StudentService {

	List<Student> getAll();
	void saveStudent(Student student);
	Student getById(Long id);
	void update(Student student, Long id);
}
