package com.springBoot.security.controller;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

	@GetMapping
	public String firstPage(Principal principal, Model model) {
		
		model.addAttribute("user", principal.getName());
		return "index";
	}
	
	
}
