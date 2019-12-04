package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.MenuItem;

public class MenuItemDaoSqlImpl implements MenuItemDao {

	public List<MenuItem> getMenuItemListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> ls = new ArrayList<MenuItem>();
		try {

			PreparedStatement ps = con.prepareStatement("select * from menu_item");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				MenuItem menuitem = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4),
						rs.getDate(5), rs.getString(6), rs.getBoolean(7));
				ls.add(menuitem);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ls;

	}

	public List<MenuItem> getMenuItemListCustomer() {

		Connection con = ConnectionHandler.getConnection();
		List<MenuItem> lst = new ArrayList<MenuItem>();
		try {

			PreparedStatement ps = con
					.prepareStatement("SELECT * from menu_item where me_active='yes' and me_date_of_launch<=curdate()");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				MenuItem menuitem = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4),
						rs.getDate(5), rs.getString(6), rs.getBoolean(7));
				lst.add(menuitem);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}

	public MenuItem getMenuItem(long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		MenuItem me = null;
		try {

			PreparedStatement ps = con.prepareStatement("select * from menu_item where me_id=?");
			ps.setLong(1, menuItemId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				me = new MenuItem(rs.getLong(1), rs.getString(2), rs.getFloat(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return me;
	}

	public void modifyMenuItem(MenuItem menuItem) {
		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement ps;

			ps = con.prepareStatement(
					"UPDATE `truyum`.`menu_item` SET `me_name`=?, `me_price`=?, `me_active`=?,`me_date_of_launch`=?,`me_category`=?,`me_free_delivery`=?  WHERE `me_id`=?");
			ps.setString(1, menuItem.getName());
			ps.setFloat(2, menuItem.getPrice());
			ps.setBoolean(3, menuItem.isActive());
			Date da = new Date(menuItem.getDateOfLaunch().getTime());
			ps.setDate(4, da);
			ps.setString(5, menuItem.getCategory());
			ps.setBoolean(6, menuItem.isFreeDelivery());
			ps.setLong(7, menuItem.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
