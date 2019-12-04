package com.cognizant.moviecruiser.model;

import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

//import com.cognizant.truyum.model.MenuItem;

public class Favorites {

	public Favorites(List<Movie> movieList, int nooffavorites) {
		super();
		this.movieList = movieList;
		this.nooffavorites = nooffavorites;
	}

	private List<Movie> movieList;

	private int nooffavorites;

	@Override
	public String toString() {
		return "favorites [movieList=" + movieList + ", nooffavorites=" + nooffavorites + "]";
	}

	public List<Movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<Movie> movieList) {
		this.movieList = movieList;
	}

	public int getNooffavorites() {
		return nooffavorites;
	}

	public void setNooffavorites(int nooffavorites) {
		this.nooffavorites = nooffavorites;
	}

}
