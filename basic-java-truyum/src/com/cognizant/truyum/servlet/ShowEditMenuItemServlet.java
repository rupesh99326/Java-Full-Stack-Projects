package com.cognizant.truyum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;


@WebServlet("/ShowEditMenuItem")
public class ShowEditMenuItemServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

	     MenuItemDao menuItemDao=new MenuItemDaoSqlImpl();
			
			long l = Long.parseLong(request.getParameter("menuItemId"));
			request.setAttribute("menuItem",menuItemDao.getMenuItem(l));
			RequestDispatcher rd=request.getRequestDispatcher("edit-menu-item.jsp");
			rd.forward(request, response);
		
	}

}
