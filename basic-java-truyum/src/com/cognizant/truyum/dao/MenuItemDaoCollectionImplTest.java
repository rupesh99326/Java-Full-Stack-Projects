package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImplTest {

	public static void testGetMenuItemListAdmin() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListAdmin();

		for (Object o1 : menuItemList) {
			System.out.println(o1.toString());

		}

	}

	public static void testGetMenuItemListCustomer() throws ParseException {

		MenuItemDao menuItemDao = new MenuItemDaoCollectionImpl();
		List<MenuItem> menuItemList = menuItemDao.getMenuItemListCustomer();

		for (Object o1 : menuItemList) {
			System.out.println(o1.toString());

		}

	}

	public static void main(String[] arg) throws ParseException

	{

		testGetMenuItemListAdmin();

		testGetMenuItemListCustomer();
		testModifyMenuItem();
		
	}
	public static void testModifyMenuItem() throws ParseException
	{
		MenuItem ob=new MenuItem(1l, "Sandw", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
				"Main Course", true);
		MenuItemDao menuItemDao=new MenuItemDaoCollectionImpl();
		menuItemDao.modifyMenuItem(ob);
		System.out.println(menuItemDao.getMenuItem(1l));
	}
	
	
	
}