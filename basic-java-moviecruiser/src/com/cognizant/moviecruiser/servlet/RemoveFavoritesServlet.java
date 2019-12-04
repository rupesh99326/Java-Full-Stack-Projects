package com.cognizant.moviecruiser.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cognizant.moviecruiser.dao.FavoritesDao;
import com.cognizant.moviecruiser.dao.FavoritesDaoSqlImpl;
import com.cognizant.moviecruiser.dao.FavoritesEmptyException;
import com.cognizant.moviecruiser.dao.MovieDao;
import com.cognizant.moviecruiser.dao.MovieDaoSqlImpl;
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

@WebServlet("/RemoveFavorites")
public class RemoveFavoritesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		long uid = 1l;
		long menuid = Long.parseLong(request.getParameter("movieId"));
		MovieDao movieDao = new MovieDaoSqlImpl();
		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();
		// MenuItem m1=menuItemDao.getMenuItem(menuid);
		favoritesDao.removeFavoritesItem(uid, menuid);
		Favorites c1 = null;
		try {
			c1 = favoritesDao.getAllFavoritesItems(uid);
			List<Movie> cmr = c1.getMovieList();
			if (cmr.isEmpty()) {
				throw new FavoritesEmptyException();
			}
			request.setAttribute("flist", c1);
			request.setAttribute("removeFavoritesStatus", true);
			request.setAttribute("total", c1.getNooffavorites());
			RequestDispatcher rd = request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

			RequestDispatcher rd = request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response);

		}

	}

}
