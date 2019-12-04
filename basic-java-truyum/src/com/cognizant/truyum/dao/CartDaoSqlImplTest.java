package com.cognizant.truyum.dao;

import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void main(String[] args) throws Exception {
		
//		testAddCartItem();
		//testRemoveCartItem();
		testGetAllCartItems();
		
	}

	public static void testGetAllCartItems() throws Exception {
		CartDaoSqlImpl cartdao = new CartDaoSqlImpl();

		Cart c1 = cartdao.getAllCartItems(1l);
		List<MenuItem> m1 = c1.getMenuItemList();
		for (MenuItem i : m1) {
			System.out.println(i.toString());
		}
		System.out.println("Total price: "+c1.getTotal());

	}

	public static void testAddCartItem() throws Exception {
		CartDaoSqlImpl cartdao = new CartDaoSqlImpl();
		cartdao.addCartItem(1,1);
		cartdao.addCartItem(1,2);
		
		Cart c1 = cartdao.getAllCartItems(1l);
		List<MenuItem> m1 = c1.getMenuItemList();
		for (MenuItem i : m1) {
			System.out.println(i.toString());
		}

	}

	public static void testRemoveCartItem() throws Exception {
		CartDaoSqlImpl cartdao = new CartDaoSqlImpl();
		cartdao.removeCartItem(1,1);


	}

}
