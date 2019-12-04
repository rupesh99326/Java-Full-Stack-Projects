package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.CartDao;
import com.cognizant.truyum.dao.CartDaoCollectionImpl;
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/AddToCart")
public class AddToCartServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	long uid=1l;
	long menuid=Long.parseLong(request.getParameter("menuItemId"));
	MenuItemDao menuItemDao=new MenuItemDaoSqlImpl();
	CartDao cartDao = new CartDaoSqlImpl();
	//MenuItem m1=menuItemDao.getMenuItem(menuid);
	cartDao.addCartItem(uid,menuid);
	Cart c1=null;
	try
	{
		c1=cartDao.getAllCartItems(uid);
		List<MenuItem> cmr=c1.getMenuItemList();
		request.setAttribute("clist", cmr);
		request.setAttribute("addCartStatus", true);
		request.setAttribute("menuItemList",menuItemDao.getMenuItemListCustomer());
		RequestDispatcher rd=request.getRequestDispatcher("menu-item-list-customer.jsp");
		rd.forward(request, response);
	}
	catch (Exception e) {
	
		
		RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
		rd.forward(request, response);
		
	}
	
	

	
	}
	



}
