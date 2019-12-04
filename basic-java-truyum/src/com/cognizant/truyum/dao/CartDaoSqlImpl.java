package com.cognizant.truyum.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImpl implements CartDao {

	public void addCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement("select * from user where us_id=?");
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps1 = con
						.prepareStatement("INSERT INTO `truyum`.`cart` (`ct_us_id`,`ct_pr_id`) values(?,?)");
				ps1.setLong(1, userId);
				ps1.setLong(2, menuItemId);
				ps1.executeUpdate();
			}

			else {
				PreparedStatement ps2 = con
						.prepareStatement("INSERT INTO `truyum`.`user` (`us_id`,`us_name`) values(?,'Ravi')");
				ps2.setLong(1, userId);

				PreparedStatement ps3 = con
						.prepareStatement("INSERT INTO `truyum`.`cart` (`ct_us_id`,`ct_pr_id`) values(?,?)");
				ps3.setLong(1, userId);

				ps3.setLong(2, menuItemId);
				ps2.executeUpdate();
				ps3.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Cart getAllCartItems(long userId) throws CartEmptyException {
		Connection con = ConnectionHandler.getConnection();
		Cart c1 = null;

		try {

			PreparedStatement prToSelectMenuItemsOnJoinCart, prToCheckCartExist;
			PreparedStatement prToSelectTotalPrice;
			ResultSet resultSetToSelectMenuItemsOnJoinCart, resultSetToCheckCartExist;
			ResultSet resultSetToSelectTotalPrice;

			prToCheckCartExist = con.prepareStatement("select * from cart where ct_us_id=?");
			prToCheckCartExist.setLong(1, userId);

			List<MenuItem> m1 = new ArrayList<MenuItem>();
			c1 = new Cart(m1, 0);
			resultSetToCheckCartExist = prToCheckCartExist.executeQuery();
			boolean boolCheckCart = resultSetToCheckCartExist.next();
			System.out.println("boolCheckCart: " + boolCheckCart);
			if (!boolCheckCart) {
				throw new CartEmptyException();
			}
			prToSelectMenuItemsOnJoinCart = con.prepareStatement(
					"select `menu_item`.* from `menu_item` join `cart` on `menu_item`.`me_id`=`cart`.`ct_pr_id` where `cart`.`ct_us_id`=?");
			prToSelectMenuItemsOnJoinCart.setLong(1, userId);

			resultSetToSelectMenuItemsOnJoinCart = prToSelectMenuItemsOnJoinCart.executeQuery();
			while (resultSetToSelectMenuItemsOnJoinCart.next()) {
				MenuItem menuitem = new MenuItem(resultSetToSelectMenuItemsOnJoinCart.getLong(1),
						resultSetToSelectMenuItemsOnJoinCart.getString(2),
						resultSetToSelectMenuItemsOnJoinCart.getFloat(3),
						resultSetToSelectMenuItemsOnJoinCart.getString(4).equals("yes") ? true : false,
						resultSetToSelectMenuItemsOnJoinCart.getDate(5),
						resultSetToSelectMenuItemsOnJoinCart.getString(6),
						resultSetToSelectMenuItemsOnJoinCart.getString(7).equals("yes") ? true : false);
				m1.add(menuitem);
			}
			prToSelectTotalPrice = con.prepareStatement(
					"select SUM(`menu_item`.`me_price`) from menu_item join cart on `menu_item`.`me_id`=`cart`.`ct_pr_id` where `cart`.ct_us_id=?");
			prToSelectTotalPrice.setLong(1, userId);

			resultSetToSelectTotalPrice = prToSelectTotalPrice.executeQuery();
			while (resultSetToSelectTotalPrice.next()) {
				c1.setTotal(resultSetToSelectTotalPrice.getDouble(1));
			}
			c1.setMenuItemList(m1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return c1;
	}

	public void removeCartItem(long userId, long menuItemId) {
		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement ps6 = con.prepareStatement("DELETE FROM cart WHERE ct_us_id=? AND ct_pr_id=?");
			ps6.setLong(1, userId);
			ps6.setLong(2, menuItemId);
			ps6.executeUpdate();
		} catch (Exception e) {
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
