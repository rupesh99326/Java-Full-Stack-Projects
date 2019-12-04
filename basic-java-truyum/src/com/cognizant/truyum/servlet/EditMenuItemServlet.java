package com.cognizant.truyum.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.truyum.dao.MenuItemDao;
import com.cognizant.truyum.dao.MenuItemDaoCollectionImpl;
import com.cognizant.truyum.dao.MenuItemDaoSqlImpl;
import com.cognizant.truyum.model.MenuItem;

@WebServlet("/EditMenuItem")
public class EditMenuItemServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nam1, cat;
		float pr;
		long l;
		Date d = null;
		boolean f, a;

		nam1 = request.getParameter("name");
		cat = request.getParameter("select");
		pr = Float.parseFloat(request.getParameter("price"));
		SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
		try {

			d = f1.parse(request.getParameter("dateOfLaunch"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l = Long.parseLong(request.getParameter("id"));
		if (request.getParameter("active").equals("Yes")) {

			a = true;

		} else
			a = false;

		if (request.getParameter("freeDelivery") != null) {
			f = true;
		} else {

			f = false;
		}

		MenuItem m = new MenuItem(l, nam1, pr, a, d, cat, f);
		MenuItemDao menuItemDao = new MenuItemDaoSqlImpl();
		menuItemDao.modifyMenuItem(m);
		request.setAttribute("menuItemList", menuItemDao.getMenuItemListAdmin());
		RequestDispatcher rd = request.getRequestDispatcher("edit-menu-item-status.jsp");
		rd.forward(request, response);

	}

}
