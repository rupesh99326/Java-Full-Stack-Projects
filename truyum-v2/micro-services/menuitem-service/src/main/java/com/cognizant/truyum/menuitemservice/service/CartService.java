package com.cognizant.truyum.menuitemservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.menuitemservice.DTO.CartDTO;
import com.cognizant.truyum.menuitemservice.exception.CartEmptyException;
import com.cognizant.truyum.menuitemservice.model.MenuItem;
import com.cognizant.truyum.menuitemservice.model.Users;
import com.cognizant.truyum.menuitemservice.repository.MenuItemRepository;
import com.cognizant.truyum.menuitemservice.repository.UserRepository;

@Service
public class CartService {

	//
	// @Autowired
	// public CartDao cartdao;

	//
	// @Autowired
	// public CartRepository cartrepository;

	@Autowired
	public MenuItemRepository menurepository;

	@Autowired
	public UserRepository userrepository;

	public void addCartItem(String username, long menuItemId) {

		Users myuser = userrepository.findByUsername(username);
		// Optional<MenuItem> menuitem = menurepository.findById(menuItemId);
		// MenuItem Mymenu = menuitem.get();
		myuser.getMenuItems().add(menurepository.findById(menuItemId).get());

		userrepository.save(myuser);

	}

	public CartDTO getAllCartItems(String username) throws CartEmptyException {
		List<MenuItem> li = userrepository.getMenuItems(username);
		if (li == null || li.size() == 0) {
			return new CartDTO(li, 0);
		}

		double total = userrepository.getCartTotal(username);

		CartDTO dto = new CartDTO(li, total);
		return dto;
	}

	public void removeCartItem(String username, long menuItemId) {

		Users users = userrepository.findByUsername(username);
		List<MenuItem> ma = users.getMenuItems();
		MenuItem m = menurepository.findById(menuItemId).get();

		ma.remove(m);
		users.setMenuItems(ma);
		userrepository.save(users);

	}

}
