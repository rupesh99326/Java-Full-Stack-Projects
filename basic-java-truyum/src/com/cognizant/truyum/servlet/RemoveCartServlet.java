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
import com.cognizant.truyum.dao.CartDaoSqlImpl;
import com.cognizant.truyum.dao.CartEmptyException;
import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/RemoveCart")
public class RemoveCartServlet extends HttpServlet {
	
	public  void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long uid=1l;
		long menuid=Long.parseLong(request.getParameter("menuItemId"));
		MenuItemDao menuItemDao=new MenuItemDaoSqlImpl();
		CartDao cartDao = new CartDaoSqlImpl();
		//MenuItem m1=menuItemDao.getMenuItem(menuid);
		cartDao.removeCartItem(uid,menuid);
		Cart c1=null;

			try {
				c1=cartDao.getAllCartItems(uid);
				List<MenuItem> cmr=c1.getMenuItemList();
				if(cmr.isEmpty())
				{ throw new CartEmptyException();}
				request.setAttribute("clist", cmr);
				request.setAttribute("removeCartStatus", true);
				request.setAttribute("total",c1.getTotal());
				RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
			} catch (CartEmptyException e) {
				
				RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
				rd.forward(request, response);
			}
			
	
	
		
		

		
		}	
	
	
	}


