package com.cognizant.moviecruiser.movieservice.exception;

public class FavoritesEmptyException extends Exception {

	public FavoritesEmptyException()
	{
		super("Favorites is Empty");
	}
}
