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
import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

@WebServlet("/ShowFavorites")
public class ShowFavoritesServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		long uid = 1l;

		FavoritesDao favoritesDao = new FavoritesDaoSqlImpl();

		Favorites c1 = null;
		try {
			c1 = favoritesDao.getAllFavoritesItems(uid);
			List<Movie> cmr = c1.getMovieList();
			int total = c1.getNooffavorites();
			if (cmr.isEmpty()) {
				throw new FavoritesEmptyException();
			}
			request.setAttribute("flist", c1);
			request.setAttribute("total", total);

			RequestDispatcher rd = request.getRequestDispatcher("favorites.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

			RequestDispatcher rd = request.getRequestDispatcher("favorites-empty.jsp");
			rd.forward(request, response);

		}

	}

}
