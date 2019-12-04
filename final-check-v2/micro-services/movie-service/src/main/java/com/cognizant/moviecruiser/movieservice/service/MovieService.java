package com.cognizant.moviecruiser.movieservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.movieservice.model.movie;
import com.cognizant.moviecruiser.movieservice.repository.MovieItemRepository;


@Service
public class MovieService {


	@Autowired
	public MovieItemRepository movieitemrepository;
	
	
	public List<movie> getMovieListCustomer()
	{
		
		return movieitemrepository.getMenuItemCustomer();
		
	}
	
	
	public List<movie> getMovieListAdmin()
	{
		List<movie> li =new ArrayList<movie>();
		
		
		
		movieitemrepository.findAll().forEach(li::add);
		return li;
	}
//
//
	public movie getMovie(long menuItemId) {
		// TODO Auto-generated method stub
		
		 Optional<movie> result = movieitemrepository.findById(menuItemId);
		 if (result.isPresent())
		 {
			 movie movie = result.get();
			 return movie;
		 }
		// else throw new CountryNotFoundException(); 
			 return null;
	}

	 @Transactional
	 public movie addMovie(movie movie)
	 {
		return movieitemrepository.save(movie);
	 }
	 
	 @Transactional
	 public movie updateMovie(long movieitemid,movie movie)
	 {
		 Optional<movie> result = movieitemrepository.findById(movieitemid);
		 if (result.isPresent())
		 {
			 movieitemrepository.save(movie);
	
		 }
		 
	 return null;
	 }
	 
	
	
	
	
	
}
