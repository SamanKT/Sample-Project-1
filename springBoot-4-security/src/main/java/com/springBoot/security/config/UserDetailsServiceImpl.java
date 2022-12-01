package com.springBoot.security.config;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.springBoot.security.model.UserClass;
import com.springBoot.security.repository.UserRepository;

public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository repository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		UserClass userClass = repository.findByEmail(username).get(0);
		if (userClass==null) throw new UsernameNotFoundException("user is not found");
		
		return new User(userClass.getEmail(), userClass.getPassword(), grantAuthorities(userClass));
	}
	
	
	public Collection<? extends GrantedAuthority> grantAuthorities (UserClass userClass) {
		
		List<SimpleGrantedAuthority> collect = userClass.getTakenRoles().stream()
				.map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
		return collect;
		
	}
	

}
