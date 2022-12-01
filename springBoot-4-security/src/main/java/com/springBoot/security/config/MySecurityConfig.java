package com.springBoot.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class MySecurityConfig {

	@Bean
	public UserDetailsService userService() {
		return new UserDetailsServiceImpl();
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public DaoAuthenticationProvider authProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		
		authProvider.setUserDetailsService(userService());
		authProvider.setPasswordEncoder(encoder());
		return authProvider;
		
		
	}
	
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		.antMatchers("/").authenticated()
		
		.antMatchers("/register").permitAll()
		
		.and()
		.formLogin()
		.and()
		.httpBasic()
		.and()
		.authenticationProvider(authProvider());
		
		return http.build();
		
	}
	
	// take a look at this : https://spring.io/blog/2022/02/21/spring-security-without-the-websecurityconfigureradapter
	
	
}
