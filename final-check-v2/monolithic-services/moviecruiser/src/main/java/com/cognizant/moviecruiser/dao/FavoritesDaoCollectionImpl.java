//package com.cognizant.moviecruiser.dao;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//import org.springframework.stereotype.Repository;
//
//import com.cognizant.moviecruiser.model.favorites;
//import com.cognizant.moviecruiser.model.movie;
//
//@Repository
//public class FavoritesDaoCollectionImpl implements FavoritesDao {
//	private static HashMap<String, favorites> userFavorites;
//
//	public FavoritesDaoCollectionImpl() {
//		if (userFavorites == null) {
//			userFavorites = new HashMap<String, favorites>();
//			List<movie> movieList = new ArrayList<movie>();
//			favorites c = new favorites(movieList, 0);
//			userFavorites.put("", c);
//		}
//	}
//
//	@Override
//	public boolean addFavoritesItem(String userName, long movieId) {
//		// TODO Auto-generated method stub
//		MovieDao movieDao = new MovieDaoCollectionImpl();
//
//		movie m;
//		favorites c1;
//		List<movie> ml;
//		m = movieDao.getMovie(movieId);
//		if (userFavorites.containsKey(userName)) {
//
//			c1 = userFavorites.get(userName);
//			ml = c1.getMovieList();
//			for(int i=0;i<ml.size();i++){
//				if(ml.get(i).getId()==movieId){
//					return false;
//				}
//			}
//			ml.add(m);
//			c1.setMovieList(ml);
//			userFavorites.put(userName, c1);
//			return true;
//
//		} else {
//			ml = new ArrayList<movie>();
//			ml.add(m);
//			// c1.setMenuItemList(ml);
//			c1 = new favorites(ml, 0);
//			userFavorites.put(userName, c1);
//			return true;
//		}
//	}
//
//	@Override
//	public favorites getAllFavoritesItems(String userName) {
//		if (userFavorites.get(userName) != null) {
//			favorites c1;
//			List<movie> ml;
//			c1 = userFavorites.get(userName);
//			ml = c1.getMovieList();
//			if (ml.isEmpty()) {
//				return new favorites(ml,0);
//			} else {
//				userFavorites.get(userName).setNooffavorites(ml.size());
//			}
//			return userFavorites.get(userName);
//		} else
//			return new favorites(null,0);
//		
//	}
//
//	@Override
//	public void removeFavoritesItem(String userName, long movieItemId) {
//		favorites c1;
//		List<movie> ml;
//		c1 = userFavorites.get(userName);
//		// System.out.println(c1);
//		ml = c1.getMovieList();
//		for (int i = 0; i < ml.size(); i++) {
//			// MenuItem i1=(MenuItem) itr.next();
//			if (movieItemId == ml.get(i).getId()) {
//				ml.remove(i);
//			}
//
//		}
//	}
//
//}
