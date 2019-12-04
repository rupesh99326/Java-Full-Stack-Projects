package com.cognizant.truyum.dao;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImplTest {

	public static void main(String[] args) {
		testAddCartItem();
		testRemoveCartItem();
	}

	public static void testAddCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();

		cartDao.addCartItem(1l, 2l);
		//cartDao.addCartItem(2l, 3l);

		try {
			Cart c1 = cartDao.getAllCartItems(1l);
			System.out.println(c1.getMenuItemList());
		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());

		}

	}

	public static void testRemoveCartItem() {
		CartDao cartDao = new CartDaoCollectionImpl();
		cartDao.removeCartItem(1l, 2l);
		//cartDao.removeCartItem(2l, 3l);
		try {

			Cart c2 = cartDao.getAllCartItems(1l);
			System.out.println(c2.getMenuItemList());

		} catch (CartEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

}
