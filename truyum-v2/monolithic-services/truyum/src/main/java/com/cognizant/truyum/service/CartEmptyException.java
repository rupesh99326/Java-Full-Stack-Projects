package com.cognizant.truyum.service;

public class CartEmptyException extends Exception {

	

	public CartEmptyException()
	{
		super("Cart is Empty");
	}
	
}
