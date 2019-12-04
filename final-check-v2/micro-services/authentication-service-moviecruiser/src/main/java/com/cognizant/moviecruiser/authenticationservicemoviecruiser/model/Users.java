package com.cognizant.moviecruiser.authenticationservicemoviecruiser.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
@Table(name="user")
public class Users {
	@Id
	@Column(name="us_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int id;
	
	@NotNull
	@Column(name="us_username")
	private String username;
	@Column(name="us_firstname")
	private String firstname;
	@Column(name="us_lastname")
	private String lastname;
	
	@NotNull
	@Size(min=5)
	@Column(name="us_password")
	private String password;

	 @ManyToMany
	    @JoinTable(name = "favorites",
	        joinColumns = @JoinColumn(name = "fvt_us_id"), 
	        inverseJoinColumns = @JoinColumn(name = "fvt_mov_id"))
	 private List<movie> movieItems;
	 
	 @ManyToMany
	    @JoinTable(name = "user_role",
	        joinColumns = @JoinColumn(name = "ur_us_id"), 
	        inverseJoinColumns = @JoinColumn(name = "ur_ro_id"))
	 private List<Role> roles;
	 
	 
	 
	
	
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}



	@Override
	public String toString() {
		return "Users [id=" + id + ", username=" + username + ", firstname=" + firstname + ", lastname=" + lastname
				+ ", password=" + password + ", movieItems=" + movieItems + ", roles=" + roles + "]";
	}

	public List<movie> getMovieItems() {
		return movieItems;
	}

	public void setMovieItems(List<movie> movieItems) {
		this.movieItems = movieItems;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/**
	 * 
	 */
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param username
	 * @param firstname
	 * @param lastname
	 * @param password
	 */
	public Users(@NotNull String username, @NotNull String firstname, @NotNull String lastname,
			@NotNull @Size(min = 5) String password) {
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
}
