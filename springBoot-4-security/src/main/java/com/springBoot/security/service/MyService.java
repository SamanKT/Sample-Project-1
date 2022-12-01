package com.springBoot.security.service;

import com.springBoot.security.dto.UserDto;
import com.springBoot.security.model.UserClass;

public interface MyService {
	
	UserClass saveUser(UserDto userDto);

}
