package com.cognizant.truyum.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoCollectionImpl implements CartDao
{
	
	
	
	private static HashMap<Long,Cart> userCarts;
	
	public CartDaoCollectionImpl()
	{
	if(userCarts==null)
	{
		 userCarts = new HashMap<Long,Cart>();
		 List<MenuItem> m4=new ArrayList<MenuItem>();
		Cart c=new Cart(m4,0.0);
		userCarts.put(0l, c);
	}	
		
	}
	



public void addCartItem(long userId,long menuItemId)
{
	
	MenuItemDao menuItemDao= new MenuItemDaoCollectionImpl();
	MenuItem m;
	Cart c1;
	List<MenuItem> m1;
	m=menuItemDao.getMenuItem(menuItemId);
	if(userCarts.containsKey(userId))
	{
		c1=userCarts.get(userId);
		m1=c1.getMenuItemList();
		m1.add(m);
		c1.setMenuItemList(m1);
		userCarts.put(userId, c1);
		
		
	}
	else
	{
		m1=new ArrayList<MenuItem>();
		m1.add(m);
		c1=new Cart(m1,0.0);
		userCarts.put(userId,c1);
		
	}
		
	}








@Override
public Cart getAllCartItems(long userId) throws CartEmptyException {
	// TODO Auto-generated method stub
	
	Cart c1;
	
	double t=0.0;
	List<MenuItem> m1;
			c1=userCarts.get(userId);
			 m1=c1.getMenuItemList();
	if(m1.isEmpty())		

	{
		throw new CartEmptyException();
	}
	else
	{
		for(MenuItem m:m1)
		{
		t=t+m.getPrice();
		
		}
		userCarts.get(userId).setTotal(t);

	}
return userCarts.get(userId);
		
	

	
	}
@Override
public void removeCartItem(long userId, long menuItemId) {
	// TODO Auto-generated method stub
	MenuItem m;
	List<MenuItem> m1;
	Cart c1;
	c1=userCarts.get(userId);
	m1=c1.getMenuItemList();
	
	for(int i=0;i<m1.size();i++)
	{
		//MenuItem i2=(MenuItem) i1.next();
		if(menuItemId==m1.get(i).getId())
		{
			m1.remove(i);
			
		}
		
	}
	
}
	
}




