package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void main(String [] args) throws Exception
	{
		testgetMenuItemListAdmin();
		testgetMenuItemListCustomer();
		testModifyMenuItem();
		testgetMenuItem();
	}
	public static void  testgetMenuItemListAdmin() throws Exception {
		MenuItemDaoSqlImpl menudao = new MenuItemDaoSqlImpl();
		List<MenuItem> mal = menudao.getMenuItemListAdmin();

		for (MenuItem i : mal) {
			System.out.println(i.toString());

		}
	}
	
	public static void  testgetMenuItemListCustomer() throws Exception
	{
		MenuItemDaoSqlImpl menudao = new MenuItemDaoSqlImpl();
		List<MenuItem> mal = menudao.getMenuItemListCustomer();

		for (MenuItem i : mal) {
			System.out.println(i.toString());

		}
	}
	
	public static void testModifyMenuItem() throws Exception
	{
		MenuItemDaoSqlImpl menudao=new MenuItemDaoSqlImpl();
		MenuItem ob=new MenuItem(4l, "sun", 99.00f, true, DateUtil.convertToDate("15/04/2017"),
				"Course", true);
		
		menudao.modifyMenuItem(ob);
		List<MenuItem> mla=menudao.getMenuItemListAdmin();
		for(MenuItem i:mla)
		{
			System.out.println(i.toString());
			
		}
		
		
	}
	public static void  testgetMenuItem() throws Exception
	{
		MenuItemDaoSqlImpl menudao=new MenuItemDaoSqlImpl();
		MenuItem me=menudao.getMenuItem(4l);
		System.out.println(me.toString());
	}
	
	
}
