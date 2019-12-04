package com.cognizant.truyum.menuitemservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.truyum.menuitemservice.model.MenuItem;
import com.cognizant.truyum.menuitemservice.security.AppUserDetailsService;
import com.cognizant.truyum.menuitemservice.service.MenuItemService;



@RestController
@RequestMapping("/menu-items")
public class MenuItemController {

	@Autowired
	public MenuItemService menuitemservice;
	
//	@Autowired
//	public InMemoryUserDetailsManager inMemoryUserDetailsManager;
	
	@Autowired
	public AppUserDetailsService appUserDetailsService;
	
	@GetMapping
	public List<MenuItem> getAllMenuItems()
	{
		
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
				String user = authentication.getName();
				
				if(!user.equalsIgnoreCase("anonymousUser")){
				UserDetails userDetails = appUserDetailsService.loadUserByUsername(user);
				String role = userDetails.getAuthorities().toArray()[0].toString();

			//	String sub=role.substring(5);
				if(role.equalsIgnoreCase("ADMIN"))
				{
					
					
					return menuitemservice.getMenuItemListAdmin();
				}
				else 				{
					return menuitemservice.getMenuItemListCustomer();
				}
				}
				else return menuitemservice.getMenuItemListCustomer();
	}
	
	
	@GetMapping("/{id}")
	public  MenuItem getMenuItem(@PathVariable long id)
	{
	return menuitemservice.getMenuItem(id);
	}
	

	@PostMapping
	public  MenuItem AddMenuItem(@RequestBody MenuItem menuitem)
	{
	return menuitemservice.addMenuItem(menuitem);
	}
	

	@PutMapping("/{menuitemid}")
	public void modifyMenuItem(@PathVariable long menuitemid,@RequestBody MenuItem menuItem)
	{
	 menuitemservice.updateMenuItem(menuitemid, menuItem);
	}

	
	
}
