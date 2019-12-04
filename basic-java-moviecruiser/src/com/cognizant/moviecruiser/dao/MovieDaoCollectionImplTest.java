package com.cognizant.moviecruiser.dao;

import java.text.ParseException;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;

public class MovieDaoCollectionImplTest {

	public static void testGetMovieListAdmin() throws ParseException {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListAdmin();

		for (Object o1 : movieList) {
			System.out.println(o1.toString());

		}

	}

	public static void testGetMovieListCustomer() throws ParseException {

		MovieDao movieDao = new MovieDaoCollectionImpl();
		List<Movie> movieList = movieDao.getMovieListCustomer();

		for (Object o1 : movieList) {
			System.out.println(o1.toString());

		}

	}

	public static void main(String[] arg) throws ParseException

	{

		testGetMovieListAdmin();

		testGetMovieListCustomer();
		testModifyMovie();

	}

	public static void testModifyMovie() throws ParseException {
		Movie ob = new Movie(1l, "Avat", 2787965087l, true, DateUtil.convertToDate("15/03/2017"), "Science Fiction",
				true);
		MovieDao movieDao = new MovieDaoCollectionImpl();
		movieDao.modifyMovie(ob);
		System.out.println(movieDao.getMovie(1l));
	}

}