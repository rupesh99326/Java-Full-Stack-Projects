package com.cognizant.truyum.menuitemservice.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="menu_item")
public class MenuItem {

	@Id
	@Column(name="me_id")
	private long id;
	
	
	@Column(name="me_name")
	private String name;
	@Column(name="me_price")
	private float price;
	@Column(name="me_active")
	private boolean active;
	@Column(name="me_date_of_launch")
	private Date Date_of_Launch;
	@Column(name="me_category")
	private String category;
	@Column(name="me_free_delivery")
	private boolean free_delivery;

	
	@Column(name="me_image")
	private String image;


	 @ManyToMany
	    @JoinTable(name = "cart",
	        joinColumns = @JoinColumn(name = "ct_pr_id"), 
	        inverseJoinColumns = @JoinColumn(name = "ct_us_id"))
	private List<Users> users;

	
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDate_of_Launch() {
		return Date_of_Launch;
	}

	public void setDate_of_Launch(Date date_of_Launch) {
		Date_of_Launch = date_of_Launch;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isFree_delivery() {
		return free_delivery;
	}

	public void setFree_delivery(boolean free_delivery) {
		this.free_delivery = free_delivery;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}


	public MenuItem(long id, String name, float price, boolean active, Date date_of_Launch, String category,
			boolean free_delivery, String image) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.active = active;
		Date_of_Launch = date_of_Launch;
		this.category = category;
		this.free_delivery = free_delivery;
		this.image = image;
	}

	public MenuItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MenuItem other = (MenuItem) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MenuItem [id=" + id + ", name=" + name + ", price=" + price + ", active=" + active + ", Date_of_Launch="
				+ Date_of_Launch + ", category=" + category + ", free_delivery=" + free_delivery + ", image=" + image
				+"]";
	}
	
	
	
	
	
	
	
}
