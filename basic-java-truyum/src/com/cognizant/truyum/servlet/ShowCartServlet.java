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
import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;


@WebServlet("/ShowCart")
public class ShowCartServlet extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long uid=1l;
		CartDao cartDao = new CartDaoSqlImpl();
		Cart c1=null;
			try {
				c1=cartDao.getAllCartItems(uid);
				List<MenuItem> cmr=c1.getMenuItemList();
				double total =c1.getTotal();
				if(cmr.isEmpty())
				{throw new CartEmptyException();}
				request.setAttribute("clist", cmr);
				request.setAttribute("total", total);
		
				RequestDispatcher rd=request.getRequestDispatcher("cart.jsp");
				rd.forward(request, response);
			} catch (CartEmptyException e) {
				
					System.out.println(e.getMessage());
					RequestDispatcher rd=request.getRequestDispatcher("cart-empty.jsp");
					rd.forward(request, response);
					
				
			}
			
		}
		
		
	

	

}
