package com.cognizant.truyum.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;



@WebServlet("/ShowMenuItemListAdmin")
public class ShowMenuItemListAdminServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		MenuItemDao menuItemDao=new MenuItemDaoSqlImpl();
		
		
		request.setAttribute("menuItemList",menuItemDao.getMenuItemListAdmin());
		//System.out.println("inside showmenuadmin: "+menuItemDao.getMenuItemListAdmin());
		RequestDispatcher rd=request.getRequestDispatcher("menu-item-list-admin.jsp");
		rd.forward(request, response);
	
	}

}
