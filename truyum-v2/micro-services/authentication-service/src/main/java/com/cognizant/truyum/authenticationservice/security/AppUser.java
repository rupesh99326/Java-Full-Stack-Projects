package com.cognizant.truyum.authenticationservice.security;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.cognizant.truyum.authenticationservice.model.Users;


public class AppUser implements UserDetails{

	
	
    private Users user; // entity reference
    private Collection<? extends GrantedAuthority> authorities; // to store role details
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return this.authorities ;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true ;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true ;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true ;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true ;
	}

	/**
	 * 
	 */
	public AppUser() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param user
	 */
	public AppUser(Users user) {
		super();
		this.user = user;
		 this.authorities = user.getRoles().stream()
	                .map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "AppUser [user=" + user + ", authorities=" + authorities + "]";
	}

}
