package com.cognizant.moviecruiser.exception;

public class FavoritesEmptyException extends Exception {

	public FavoritesEmptyException()
	{
		super("Favorites is Empty");
	}
}
