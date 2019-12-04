package com.cognizant.moviecruiser.service;

import java.awt.MenuItem;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.moviecruiser.favoritesDTO;
import com.cognizant.moviecruiser.exception.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Users;
import com.cognizant.moviecruiser.model.movie;
import com.cognizant.moviecruiser.repository.MovieItemRepository;
import com.cognizant.moviecruiser.repository.UserRepository;



@Service
public class FavoritesService {

	
//
//	@Autowired
//	public FavoritesDao favoritesDao;
//	
//	
	@Autowired
	public MovieItemRepository movierepository;

	@Autowired
	public UserRepository userrepository;

	public void addFavoritesItem(String username, long menuItemId) {

		Users myuser = userrepository.findByUsername(username);
		myuser.getMovieItems().add(movierepository.findById(menuItemId).get());

		userrepository.save(myuser);

	}

	public favoritesDTO getAllFavoritesItems(String username) throws FavoritesEmptyException {
		List<movie> li = userrepository.getMovieItems(username);
		if (li == null || li.size() == 0) {
			return new favoritesDTO(li, 0);
		}
		
		int total =li.size();
		//double total = userrepository.getCartTotal(username);

		favoritesDTO dto = new favoritesDTO(li, total);
		return dto;
	}

	public void removeFavoritesItem(String username, long menuItemId) {

		Users users = userrepository.findByUsername(username);
		List<movie> ma = users.getMovieItems();
		movie m = movierepository.findById(menuItemId).get();

		ma.remove(m);
		users.setMovieItems(ma);
		userrepository.save(users);

	}
	
	
}
