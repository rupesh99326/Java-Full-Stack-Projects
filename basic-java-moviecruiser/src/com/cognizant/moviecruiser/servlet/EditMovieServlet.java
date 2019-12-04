package com.cognizant.moviecruiser.servlet;

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

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.model.Movie;

@WebServlet("/EditMovie")
public class EditMovieServlet extends HttpServlet {

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String nam1, cat;
		long pr;
		long l;
		Date d = null;
		boolean f, a;

		nam1 = request.getParameter("name");
		cat = request.getParameter("select");
		// pr=Float.parseFloat(request.getParameter("price"));
		pr = Long.parseLong(request.getParameter("price"));
		SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
		try {

			d = f1.parse(request.getParameter("dateOfLaunch"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		l = Long.parseLong(request.getParameter("id"));
		if (request.getParameter("active") != null) {

			a = true;

		} else
			a = false;

		if (request.getParameter("Delivery") != null) {
			f = true;
		} else {

			f = false;
		}

		Movie m = new Movie(l, nam1, pr, a, d, cat, f);
		MovieDao movieDao = new MovieDaoSqlImpl();
		movieDao.modifyMovie(m);
		// String s= m.toString();
		// System.out.println(s);
		request.setAttribute("movieList", movieDao.getMovieListAdmin());
		// System.out.println("inside EdiTMenuServlet:
		// "+menuItemDao.getMenuItemListAdmin());
		RequestDispatcher rd = request.getRequestDispatcher("edit-movie-status.jsp");
		rd.forward(request, response);

	}

}
