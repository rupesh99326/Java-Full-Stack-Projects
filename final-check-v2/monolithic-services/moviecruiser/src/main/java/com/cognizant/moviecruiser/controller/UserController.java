package com.cognizant.moviecruiser.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Users;
import com.cognizant.moviecruiser.security.AppUserDetailsService;


@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	public AppUserDetailsService detailservice;

	@Autowired
	public InMemoryUserDetailsManager inMemoryUserDetailsManager;

	
		
	@PostMapping 
	public boolean signup(@RequestBody @Valid Users user) 
	{

		return detailservice.signup(user);
	
	}
	
}
