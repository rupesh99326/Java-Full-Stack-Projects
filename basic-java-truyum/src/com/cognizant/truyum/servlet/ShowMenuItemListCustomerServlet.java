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

@WebServlet("/ShowMenuItemListCustomer")
public class ShowMenuItemListCustomerServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		
		System.out.println(menuItemDao.getMenuItemListCustomer());

		request.setAttribute("menuItemList", menuItemDao.getMenuItemListCustomer());

		RequestDispatcher rd = request.getRequestDispatcher("menu-item-list-customer.jsp");
		rd.forward(request, response);

	}

}
