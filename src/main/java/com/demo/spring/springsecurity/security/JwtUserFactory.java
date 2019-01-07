package com.demo.spring.springsecurity.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.demo.spring.springsecurity.model.User;

public class JwtUserFactory {

	public static JwtUser create(User user) {
		
		
		return new JwtUser(user.getId(), user.getEmail(), user.getPassword(), user,maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+user.getRole()))), user.isEnabled());
	}

	private static Collection< GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
		
		return authorities.stream().map(Authority -> new SimpleGrantedAuthority(Authority) ).collect(Collectors.toList());
	}

}
