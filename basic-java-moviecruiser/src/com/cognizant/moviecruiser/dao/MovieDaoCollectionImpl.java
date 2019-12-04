package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImpl implements MovieDao {
	private static List<Movie> movieList;

	public MovieDaoCollectionImpl() {

		if (movieList == null) {
			movieList = new ArrayList<Movie>();
			movieList.add(new Movie(1l, "Avatar", 2787965087l, true, DateUtil.convertToDate("15/03/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(2l, "The Avengers", 1518812968l, true, DateUtil.convertToDate("23/12/2017"),
					"Superhero", false));
			movieList.add(new Movie(3l, "Titanic", 2187463944l, true, DateUtil.convertToDate("21/08/2018"), "Romance",
					false));
			movieList.add(new Movie(4l, "Jurassic World", 1671713208l, false, DateUtil.convertToDate("02/07/2017"),
					"Science Fiction", true));
			movieList.add(new Movie(5l, "Avengers: End Game", 2750760348l, true, DateUtil.convertToDate("02/11/2022"),
					"Superhero", true));

		}

	}

	public List<Movie> getMovieListCustomer() {
		List<Movie> movieListCustomer = new ArrayList<Movie>();

		Calendar cal = Calendar.getInstance();
		Date d = cal.getTime();
		Date d1 = new Date();

		SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
		String s1 = f1.format(d);
		try {
			d1 = f1.parse(s1);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		for (int i = 0; i < movieList.size(); i++) {
			Movie m1 = movieList.get(i);
			if (m1.isActive() && (d1.after(m1.getDateOfLaunch()))) {
				movieListCustomer.add(m1);
			}

		}
		/*
		 * Iterator itr = movieItemList.iterator();
		 * 
		 * while (itr.hasNext()) {
		 * 
		 * MenuItem i = (MenuItem) itr.next(); if (i.isActive() &&
		 * (!d1.after(i.getDateOfLaunch()))) { movieItemListCustomer.add(i); } }
		 */
		return movieListCustomer;
	}

	@Override
	public void modifyMovie(Movie movie) {
		// TODO Auto-generated method stub
		/*
		 * Iterator<MenuItem> i1 = movieItemList.iterator(); while
		 * (i1.hasNext()) { MenuItem m1 = (MenuItem) i1.next(); if
		 * (menuItem.equals(m1)) { movieItemList.remove(m1);
		 * movieItemList.add(menuItem); }
		 * 
		 */

		for (int i = 0; i < movieList.size(); i++) {
			Movie m1 = movieList.get(i);
			if (movie.equals(m1)) {
				movieList.remove(m1);
				movieList.add(movie);
			}

		}

	}

	@Override
	public Movie getMovie(long movieId) {
		// TODO Auto-generated method stub
		for (Movie o1 : movieList) {
			if (o1.getId() == movieId) {
				return o1;

			}
		}

		return null;
	}

	public List<Movie> getMovieListAdmin()

	{

		return movieList;
	}

}
