package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;
import com.cognizant.moviecruiser.util.DateUtil;



public class MovieDaoSqlImplTest {

	public static void main(String [] args) throws Exception
	{
		testgetMovieListAdmin();
		testgetMovieListCustomer();
		testModifyMovie();
		testgetMovie();
	}
	public static void  testgetMovieListAdmin() throws Exception {
		MovieDaoSqlImpl moviedao = new MovieDaoSqlImpl();
		List<Movie> mal = moviedao.getMovieListAdmin();

		for (Movie i : mal) {
			System.out.println(i.toString());

		}
	}
	
	public static void  testgetMovieListCustomer() throws Exception
	{
		MovieDaoSqlImpl moviedao = new MovieDaoSqlImpl();
		List<Movie> mal = moviedao.getMovieListCustomer();

		for (Movie i : mal) {
			System.out.println(i.toString());

		}
	}
	
	public static void testModifyMovie() throws Exception
	{
		MovieDaoSqlImpl moviedao=new MovieDaoSqlImpl();
		Movie ob = new Movie(4l, "Spider", 2787965087l, false, DateUtil.convertToDate("15/03/2017"), "Starks",
				true);
		
		moviedao.modifyMovie(ob);
		List<Movie> mla=moviedao.getMovieListAdmin();
		for(Movie i:mla)
		{
			System.out.println(i.toString());
			
		}
		
		
	}
	public static void  testgetMovie() throws Exception
	{
		MovieDaoSqlImpl moviedao=new MovieDaoSqlImpl();
		Movie me=moviedao.getMovie(4l);
		System.out.println(me.toString());
	}
	
	
	
	
	
}
