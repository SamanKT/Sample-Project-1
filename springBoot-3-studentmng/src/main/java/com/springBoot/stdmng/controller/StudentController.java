package com.springBoot.stdmng.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springBoot.stdmng.entity.Student;
import com.springBoot.stdmng.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service; 
	
	@GetMapping("/students")
	public String students(Model model) {
		model.addAttribute("students", service.getAll());
		return "students";
	}
	
	@GetMapping("/students/save")
	public String save(@ModelAttribute("student") Student student) {
		
		return "save";
	}
	
	@PostMapping("/students")
	public String studentSave(@ModelAttribute("student") Student student) {
		
		service.saveStudent(student);
		
		return "redirect:students";
	}
	
	@GetMapping("/students/edit/{id}")
	public String update(@PathVariable("id") Long id, Model model ) {
		
		Student student= service.getById(id);
		model.addAttribute("studentUpdate", student);
		return "update";
	}
	
	
	@PostMapping("/students/{id}")
	public String studentsPost(@PathVariable("id") Long id, @ModelAttribute("studentUpdate") Student student) {
		
		service.update(student, id);
		
		return "redirect:/students";
	}
}
