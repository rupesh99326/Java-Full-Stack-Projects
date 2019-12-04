package com.cognizant.moviecruiser.dao;

public class FavoritesEmptyException extends Exception {

	public FavoritesEmptyException() {
		super("Cart is Empty");
	}

}
