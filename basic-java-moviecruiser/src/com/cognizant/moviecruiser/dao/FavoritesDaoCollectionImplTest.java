package com.cognizant.moviecruiser.dao;

import com.cognizant.moviecruiser.model.Favorites;

public class FavoritesDaoCollectionImplTest {

	public static void main(String[] args) {
		testAddFavoritesItem();
		testRemoveFavoritesItem();
	}

	public static void testAddFavoritesItem() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();

		favoritesDao.addFavoritesItem(1l, 2l);
		// favoritesDao.addFavoritesItem(2l,3l);

		try {
			Favorites c1 = favoritesDao.getAllFavoritesItems(1l);
			System.out.println(c1.getMovieList());
		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());

		}

	}

	public static void testRemoveFavoritesItem() {
		FavoritesDao favoritesDao = new FavoritesDaoCollectionImpl();
		// favoritesDao.removeFavoritesItem(1l,2l);
		// favoritesDao.removeFavoritesItem(2l,3l);
		try {

			Favorites c2 = favoritesDao.getAllFavoritesItems(1l);
			System.out.println(c2.getMovieList());

		} catch (FavoritesEmptyException e) {
			System.out.println(e.getMessage());
		}

	}

}
