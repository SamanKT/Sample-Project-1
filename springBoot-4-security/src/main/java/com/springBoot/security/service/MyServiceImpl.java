package com.springBoot.security.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.springBoot.security.dto.UserDto;
import com.springBoot.security.model.UserClass;
import com.springBoot.security.repository.RoleRepository;
import com.springBoot.security.repository.UserRepository;

@Service
public class MyServiceImpl implements MyService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private PasswordEncoder encoder;
	
	@Override
	public UserClass saveUser(UserDto userDto) {
		
		
		UserClass userClass = new UserClass();
		userClass.setName(userDto.getName());
		userClass.setLastName(userDto.getLastName());
		userClass.setEmail(userDto.getEmail());
		userClass.setPassword(encoder.encode(userDto.getPassword()));
		userDto.getRoles().forEach(a -> {
			if (roleRepository.findByName(a.getName())==null)  userClass.getTakenRoles().add(a);
			else userClass.getTakenRoles().add(roleRepository.findByName(a.getName()));
		});
		
		return userRepository.save(userClass);
	}
	
	
	

}
