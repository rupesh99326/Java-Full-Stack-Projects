package com.cognizant.moviecruiser.movieservice.controller;

import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.movieservice.model.movie;
import com.cognizant.moviecruiser.movieservice.security.AppUserDetailsService;
import com.cognizant.moviecruiser.movieservice.service.MovieService;



@RestController
@RequestMapping("/movies")
public class MovieController {



	@Autowired
	public MovieService movieservice;
	
	@Autowired
	public InMemoryUserDetailsManager inMemoryUserDetailsManager;
	@Autowired
	private AppUserDetailsService appUserDetailsService;
	@GetMapping
	public List<movie> getAllMovies()
	{
		
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
				String user = authentication.getName();
				
				if(!user.equalsIgnoreCase("anonymousUser")){
				UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
				String role = userDetails.getAuthorities().toArray()[0].toString();

				if(role.equalsIgnoreCase("ADMIN"))
				{
					
					
					return movieservice.getMovieListAdmin();
				}
				else 				{
					return movieservice.getMovieListCustomer();
				}
				}
				else return movieservice.getMovieListCustomer();
	}
	
	
	@GetMapping("/{id}")
	public  movie getMovie(@PathVariable long id)
	{
	return movieservice.getMovie(id);
	}

	@PutMapping("/{id}")
	public void modifyMovie(@PathVariable long id,@RequestBody movie movie)
	{
		movieservice.updateMovie(id,movie);
	}

	
}
