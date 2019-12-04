//package com.cognizant.moviecruiser.dao;
//
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Calendar;
//import java.util.Date;
//import java.util.List;
//
//import org.assertj.core.util.DateUtil;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.support.ClassPathXmlApplicationContext;
//import org.springframework.stereotype.Repository;
//
//import com.cognizant.moviecruiser.model.movie;
//
//@Repository
//public class MovieDaoCollectionImpl implements MovieDao {
//	private static List<movie> movieList;
//
//	public MovieDaoCollectionImpl() {
//		if (movieList==null) {
//			
//			ApplicationContext context =new ClassPathXmlApplicationContext("moviecruiser.xml");
//			
//			movieList =(ArrayList<movie>)context.getBean("movies");
//		}
//	}
//
//	public List<movie> getMovieListCustomer() {
//		List<movie> movieListCustomer = new ArrayList<movie>();
//
//		Calendar cal = Calendar.getInstance();
//		Date d = cal.getTime();
//		Date d1 = new Date();
//
//		SimpleDateFormat f1 = new SimpleDateFormat("dd/MM/yyyy");
//		String s1 = f1.format(d);
//		try {
//			d1 = f1.parse(s1);
//
//		} catch (ParseException e) {
//			e.printStackTrace();
//		}
//
//		for (int i = 0; i < movieList.size(); i++) {
//			movie m1 = movieList.get(i);
//			if (m1.isActive() && (d1.after(m1.getDate_of_Launch()))) {
//				movieListCustomer.add(m1);
//			}
//
//		}
//	
//		return movieListCustomer;
//	}
//
//	@Override
//	public void modifyMovie(movie movie) {
//		for(int i=0;i<movieList.size();i++)
//		{
//			movie m1=movieList.get(i);
//			if(movie.getId()==m1.getId())
//					{	//menuItemList.set(i,menuItem);
//				movieList.remove(i);
//				movieList.add(movie);
//					}
//		}
//
//	}
//
//	@Override
//	public movie getMovie(long movieId) {
//		// TODO Auto-generated method stub
//		for (movie o1 : movieList) {
//			if (o1.getId() == movieId) {
//				return o1;
//
//			}
//		}
//
//		return null;
//	}
//
//	public List<movie> getMovieListAdmin()
//
//	{
//
//		return movieList;
//	}
//
//}
