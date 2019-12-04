package com.cognizant.moviecruiser.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;

@WebServlet("/ShowMovieListAdmin")
public class ShowMovieListAdminServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		MovieDao movieDao = new MovieDaoSqlImpl();

		request.setAttribute("movieList", movieDao.getMovieListAdmin());
		// System.out.println("inside showmenuadmin:
		// "+menuItemDao.getMenuItemListAdmin());
		RequestDispatcher rd = request.getRequestDispatcher("movie-list-admin.jsp");
		rd.forward(request, response);

	}

}
