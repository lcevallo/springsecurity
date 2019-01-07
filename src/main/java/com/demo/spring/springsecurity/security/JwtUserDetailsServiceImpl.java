package com.demo.spring.springsecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.spring.springsecurity.model.User;
import com.demo.spring.springsecurity.repository.UserRepository;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
		
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user= userRepository.findByEmailIgnoreCase(username);
		if(user == null) {
			throw new UsernameNotFoundException(String.format("No hay usuario con este mail '%s'", username));
		}
		else {
			return JwtUserFactory.create(user);
		}
		
	}
	
	
}
