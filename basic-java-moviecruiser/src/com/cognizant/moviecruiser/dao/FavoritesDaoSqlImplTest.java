package com.cognizant.moviecruiser.dao;

import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

public class FavoritesDaoSqlImplTest {

	public static void main(String[] args) throws Exception {

		testAddFavoritesItem();
		testRemoveFavoritesItem();
		testGetAllFavoritesItems();

	}

	public static void testGetAllFavoritesItems() throws Exception {
		FavoritesDaoSqlImpl favoritesdao = new FavoritesDaoSqlImpl();

		Favorites c1 = favoritesdao.getAllFavoritesItems(1l);
		List<Movie> m1 = c1.getMovieList();
		for (Movie i : m1) {
			System.out.println(i.toString());
		}
		System.out.println("Total No of Favorites: " + c1.getNooffavorites());

	}

	public static void testAddFavoritesItem() throws Exception {
		FavoritesDaoSqlImpl favoritesdao = new FavoritesDaoSqlImpl();
		favoritesdao.addFavoritesItem(1, 1);
		favoritesdao.addFavoritesItem(1, 2);

		Favorites c1 = favoritesdao.getAllFavoritesItems(1l);
		List<Movie> m1 = c1.getMovieList();
		for (Movie i : m1) {
			System.out.println(i.toString());
		}

	}

	public static void testRemoveFavoritesItem() throws Exception {
		FavoritesDaoSqlImpl favoritesdao = new FavoritesDaoSqlImpl();
		favoritesdao.removeFavoritesItem(1, 1);

	}
}
