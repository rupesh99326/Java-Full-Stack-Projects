package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;

import com.cognizant.moviecruiser.model.Movie;

public class FavoritesDaoCollectionImpl implements FavoritesDao {

	private static HashMap<Long, Favorites> userFavorites;

	public FavoritesDaoCollectionImpl() {
		if (userFavorites == null) {
			userFavorites = new HashMap<Long, Favorites>();
			List<Movie> m4 = new ArrayList<Movie>();
			Favorites c = new Favorites(m4, 0);
			userFavorites.put(0l, c);
		}

	}

	public void addFavoritesItem(long userId, long movieId) {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		Movie m;
		Favorites c1;
		List<Movie> m1;
		m = movieDao.getMovie(movieId);
		if (userFavorites.containsKey(userId)) {
			c1 = userFavorites.get(userId);
			m1 = c1.getMovieList();
			m1.add(m);
			c1.setMovieList(m1);
			userFavorites.put(userId, c1);

		} else {
			m1 = new ArrayList<Movie>();
			m1.add(m);
			c1 = new Favorites(m1, 0);
			userFavorites.put(userId, c1);

		}

	}

	@Override
	public void removeFavoritesItem(long userId, long movieId) {
		// TODO Auto-generated method stub
		Movie m;
		List<Movie> m1;
		Favorites c1;
		c1 = userFavorites.get(userId);
		m1 = c1.getMovieList();

		for (int i = 0; i < m1.size(); i++) {
			// MenuItem i2=(MenuItem) i1.next();
			if (movieId == m1.get(i).getId()) {
				m1.remove(i);

			}

		}

	}

	@Override
	public Favorites getAllFavoritesItems(long userId) throws FavoritesEmptyException {
		if (userFavorites.get(userId) != null) {
			Favorites c1;

			int t = 0;
			List<Movie> m1;
			c1 = userFavorites.get(userId);
			m1 = c1.getMovieList();
			if (m1.isEmpty())

			{
				throw new FavoritesEmptyException();
			} else {

				userFavorites.get(userId).setNooffavorites(m1.size());

			}
			return userFavorites.get(userId);

		} else
			throw new FavoritesEmptyException();
	}
}
