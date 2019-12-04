package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.dao.FavoritesEmptyException;
import com.cognizant.moviecruiser.model.Favorites;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public interface FavoritesDao {
	public void addFavoritesItem(long userId, long menuItemId);

	public Favorites getAllFavoritesItems(long userId) throws FavoritesEmptyException;

	public void removeFavoritesItem(long userId, long movieItemId);

}
