package com.cognizant.truyum.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.DTO.CartDTO;
import com.cognizant.truyum.service.CartEmptyException;
import com.cognizant.truyum.service.CartService;

@RestController
@RequestMapping("/carts")
public class CartController {

	@Autowired
	public CartService cartservice;
	
	
	
	

	@PostMapping("/{userName}/{menuItemId}")
	public void addCartItem(@PathVariable String userName,@PathVariable long  menuItemId){
		System.out.println("Inside Add Cart post Controller");
		cartservice.addCartItem(userName, menuItemId);
	}
	
	@GetMapping("/{userName}")
	public  CartDTO getAllCartItems(@PathVariable String userName) throws CartEmptyException{
	return cartservice.getAllCartItems(userName);
	}
	
	@DeleteMapping("/{userName}/{menuItemId}")
	public void removeCartItem(@PathVariable String userName,@PathVariable  long  menuItemId)
	{
		cartservice.removeCartItem(userName, menuItemId);
	}
	
	
	
	
}
