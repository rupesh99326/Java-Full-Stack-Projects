package com.cognizant.truyum.menuitemservice.DTO;

import java.util.List;

import com.cognizant.truyum.menuitemservice.model.MenuItem;



public class CartDTO {

//	private Set<MenuItem> menuItemList=new HashSet<MenuItem>();
	
	
	private  List<MenuItem> menuItemList;
	private double total;

	public CartDTO(List<MenuItem> menuItemList, double total) {
		// TODO Auto-generated constructor stub
	this.menuItemList=menuItemList;
		this.total=total;
	}

	









	public List<MenuItem> getMenuItemList() {
		return menuItemList;
	}






	public void setMenuItemList(List<MenuItem> menuItemList) {
		this.menuItemList = menuItemList;
	}






	/**
	 * @param menuItemList
	 * @param total
	 */
//	public CartDTO(Set<MenuItem> menuItemList, double total) {
//		super();
//		this.menuItemList = menuItemList;
//		this.total = total;
//	}
//
//
//
//	public Set<MenuItem> getMenuItemList() {
//		return menuItemList;
//	}
//
//
//
//	public void setMenuItemList(Set<MenuItem> menuItemList) {
//		this.menuItemList = menuItemList;
//	}



	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}



	/**
	 * @param total
	 */



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CartDTO other = (CartDTO) obj;
		if (menuItemList == null) {
			if (other.menuItemList != null)
				return false;
		} else if (!menuItemList.equals(other.menuItemList))
			return false;
		if (Double.doubleToLongBits(total) != Double.doubleToLongBits(other.total))
			return false;
		return true;
	}

	

}
