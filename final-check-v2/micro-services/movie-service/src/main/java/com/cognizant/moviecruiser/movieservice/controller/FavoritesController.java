package com.cognizant.moviecruiser.movieservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.movieservice.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.movieservice.model.favoritesDTO;
import com.cognizant.moviecruiser.movieservice.service.FavoritesService;


@RestController
@RequestMapping("/favorites")
public class FavoritesController {

	

	@Autowired
	public FavoritesService favoritesservice;
	
	
	

	@PostMapping("/{userName}/{movieId}")
	public void addFavoritesItem(@PathVariable String userName,@PathVariable long  movieId){
		System.out.println("Inside Add Favorites post Controller");
		favoritesservice.addFavoritesItem(userName, movieId);
	}
	
	@GetMapping("/{userName}")
	public  favoritesDTO getAllFavoritesItems(@PathVariable String userName)throws FavoritesEmptyException{
		
		
		return favoritesservice.getAllFavoritesItems(userName);
	}
	
	@DeleteMapping("/{userName}/{movieId}")
	public void removeFavoritesItem(@PathVariable String userName,@PathVariable  long  movieId)
	{
		favoritesservice.removeFavoritesItem(userName, movieId);
	}
	
	
	
	
}
