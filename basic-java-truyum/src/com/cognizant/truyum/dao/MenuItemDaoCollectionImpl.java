package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoCollectionImpl implements MenuItemDao {

	private static List<MenuItem> menuItemList;
	

	public MenuItemDaoCollectionImpl() {

		if (menuItemList==null) {
		
			menuItemList = new ArrayList<MenuItem>();
			menuItemList.add(new MenuItem(1l, "Sandwich", 99.00f, true, DateUtil.convertToDate("15/03/2017"),
					"Main Course", true));
			menuItemList.add(new MenuItem(2l, "Burger", 129.00f, true, DateUtil.convertToDate("23/12/2017"),
					"Main Course", false));
			menuItemList.add(new MenuItem(3l, "Pizza", 149.00f, true, DateUtil.convertToDate("21/08/2018"),
					"Main Course", false));
			menuItemList.add(new MenuItem(4l, "French Fries", 57.00f, false, DateUtil.convertToDate("02/07/2017"),
					"Starters", true));
			menuItemList.add(new MenuItem(5l, "Chocolate Brownie", 32.00f, true, DateUtil.convertToDate("02/11/2022"),
					"Dessert", true));

		}

	}

	public List<MenuItem> getMenuItemListAdmin()

	{

		return menuItemList;
	}

	public List<MenuItem> getMenuItemListCustomer() {
		List<MenuItem> menuItemListCustomer = new ArrayList<MenuItem>();

		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		Date d1 = new Date();

		SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
		String s1 = f1.format(d);
		try {
			d1 = f1.parse(s1);

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		for(int i=0;i<menuItemList.size();i++)
		{
			MenuItem m1=menuItemList.get(i);
			if(m1.isActive() && (d1.after(m1.getDateOfLaunch())))
					{	menuItemListCustomer.add(m1);}
			
		}
		
		return menuItemListCustomer;
	}
	@Override
	public void modifyMenuItem(MenuItem menuItem) {

			for(int i=0;i<menuItemList.size();i++)
			{
				MenuItem m1=menuItemList.get(i);
				if(menuItem.equals(m1))
						{	menuItemList.set(i,menuItem);
						
						}
			}

		}

	@Override
	public MenuItem getMenuItem(long menuItemId) {
		for(MenuItem o1:menuItemList)
		{
			if(o1.getId()==menuItemId)
			{
				return o1;
				
			}
		}
		
		
		
		return null;
	}

}
