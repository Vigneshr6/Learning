package com.vignesh.springboot_playground.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.vignesh.springboot_playground.model.User;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String userName = authentication.getName();
		String password = authentication.getCredentials().toString();
		System.out.println("userName : " + userName);
		System.out.println("password : " + password);
		User user = userService.findByUsername(userName).orElse(null);
		if (user == null || !user.getPassword().equals(password)) {
			System.out.println("Invalid Credentials");
			return null;
		}
		System.out.println("user : " + user);
		return new UsernamePasswordAuthenticationToken(userName, password, user.getGrants());
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
