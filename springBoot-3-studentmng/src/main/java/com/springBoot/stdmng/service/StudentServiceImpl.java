package com.springBoot.stdmng.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springBoot.stdmng.entity.Student;
import com.springBoot.stdmng.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentRepository repository;
	
	@Override
	public List<Student> getAll() {
	
		return repository.findAll();
	}

	@Override
	public void saveStudent(Student student) {

		repository.save(student);
	}

	@Override
	public Student getById(Long id) {
		
		return repository.findById(id).get();
	}

	@Override
	public void update(Student student, Long id) {
		Student newStudent = repository.findById(id).get();
		
		newStudent.setId(student.getId());
		newStudent.setName(student.getName());
		newStudent.setSurname(student.getSurname());
		newStudent.setEmail(student.getEmail());
		
		repository.save(newStudent);
		
		
	}

}
