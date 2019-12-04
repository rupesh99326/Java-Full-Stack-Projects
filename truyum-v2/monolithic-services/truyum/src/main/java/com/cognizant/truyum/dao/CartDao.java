package com.cognizant.truyum.dao;

import com.cognizant.truyum.DTO.CartDTO;




public interface CartDao {

	
	public void addCartItem(String userName,long  menuItemId);
	public  CartDTO  getAllCartItems(String userName);
	
	public void removeCartItem(String userName,long  menuItemId);
	
	
	
}
