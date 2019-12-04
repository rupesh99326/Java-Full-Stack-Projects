package com.cognizant.truyum.model;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="role")
public class Role {
	@Id
	@Column(name="ro_id")
	private int id;
	@Column(name="ro_name")
	private String name;
	
	 @ManyToMany
	 @JoinTable(name = "user_role",
	 			joinColumns = @JoinColumn(name = "ur_ro_id"), 
	 			inverseJoinColumns = @JoinColumn(name = "ur_us_id"))
	 private List<Users> users;
	
	public List<Users> getUsers() {
		return users;
	}
	
	public void setUsers(List<Users> users) {
		this.users = users;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}