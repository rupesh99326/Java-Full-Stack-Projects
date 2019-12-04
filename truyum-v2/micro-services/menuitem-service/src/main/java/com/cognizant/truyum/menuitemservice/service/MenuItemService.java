package com.cognizant.truyum.menuitemservice.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.truyum.menuitemservice.model.MenuItem;
import com.cognizant.truyum.menuitemservice.repository.MenuItemRepository;




@Service
public class MenuItemService {

	

	
	@Autowired
	public MenuItemRepository menuitemrepository;
	
	
	public List<MenuItem> getMenuItemListCustomer()
	{
		
		return menuitemrepository.getMenuItemCustomer();
		
	}
	
	
	public List<MenuItem> getMenuItemListAdmin()
	{
		List<MenuItem> li =new ArrayList<MenuItem>();
		
		
		
		 menuitemrepository.findAll().forEach(li::add);
		return li;
	}
//
//
	public MenuItem getMenuItem(long menuItemId) {
		// TODO Auto-generated method stub
		
		 Optional<MenuItem> result = menuitemrepository.findById(menuItemId);
		 if (result.isPresent())
		 {
			 MenuItem menuitem = result.get();
			 return menuitem;
		 }
		// else throw new CountryNotFoundException(); 
			 return null;
	}

	 @Transactional
	 public MenuItem addMenuItem(MenuItem menuitem)
	 {
		return menuitemrepository.save(menuitem);
	 }
	 
	 @Transactional
	 public MenuItem updateMenuItem(long menuitemid,MenuItem menuitem)
	 {
		 Optional<MenuItem> result = menuitemrepository.findById(menuitemid);
		 if (result.isPresent())
		 {
			 menuitemrepository.save(menuitem);
	
		 }
		 
	 return null;
	 }
	 
	 

//	 @Transactional
//	 public List<Country> searchCountry(String c)
//	 {
//	 return (List<Country>) countryrepository.searchCountry(c);
//	 }	
//	
	
	
	
}
