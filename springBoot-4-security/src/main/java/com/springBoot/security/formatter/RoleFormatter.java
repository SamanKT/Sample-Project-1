package com.springBoot.security.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.springBoot.security.model.RoleClass;

public class RoleFormatter implements Formatter<RoleClass> {

	@Override
	public String print(RoleClass object, Locale locale) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public RoleClass parse(String text, Locale locale) throws ParseException {
		RoleClass role = new RoleClass();
		
		role.setName(text);
		return role;
	}

}
