package com.cognizant.truyum.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.exception.UserAlreadyExistsException;
import com.cognizant.truyum.model.Users;
import com.cognizant.truyum.security.AppUserDetailsService;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public AppUserDetailsService detailservice;

	@Autowired
	public InMemoryUserDetailsManager inMemoryUserDetailsManager;
//	@PostMapping
//	public boolean signup(@RequestBody @Valid Users user) throws UserAlreadyExistsException
//	{
//		if(inMemoryUserDetailsManager.userExists(user.getUsername()))
//				{
//			return false;
//			
//				}
//		
//		else{
//			inMemoryUserDetailsManager.createUser(User.withUsername(user.getUsername())
//	            .password(new BCryptPasswordEncoder()
//	            .encode(user.getPassword()))
//	            .roles("USER").build());
//			return true;
//		}
//		
//	
//	}
	//throws UserAlreadyExistsException
	@PostMapping 
	public boolean signup(@RequestBody @Valid Users user) 
	{
//	if(detailservice.signup(user))
		return detailservice.signup(user);
	
	}
//	else 
//		throw new UserAlreadyExistsException();
//	
//	}
//	
		
	
	
}
