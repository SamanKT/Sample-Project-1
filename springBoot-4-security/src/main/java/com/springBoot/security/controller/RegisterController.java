package com.springBoot.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springBoot.security.dto.UserDto;
import com.springBoot.security.formatter.RoleFormatter;
import com.springBoot.security.service.MyService;

@Controller
@RequestMapping("/register")
public class RegisterController {

	@Autowired
	private MyService service;
	
	@ModelAttribute("user")
	public UserDto getDto() {
		
		return new UserDto();
	}
	
	@GetMapping
	public String register() {
		
		return "registeration";
	}
	
	@PostMapping
	public String doRegister(@ModelAttribute("user") UserDto dto) {
		
		service.saveUser(dto);
		
		return "redirect:/register?success";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		binder.addCustomFormatter(new RoleFormatter());
	}
	
}
