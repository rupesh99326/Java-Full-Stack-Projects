package com.cognizant.moviecruiser.movieservice.model;

import java.util.List;



public class favoritesDTO {


	
	private List<movie> movieList;

	private int nooffavorites;

	public List<movie> getMovieList() {
		return movieList;
	}

	public void setMovieList(List<movie> movieList) {
		this.movieList = movieList;
	}

	public int getNooffavorites() {
		return nooffavorites;
	}

	public void setNooffavorites(int nooffavorites) {
		this.nooffavorites = nooffavorites;
	}

	/**
	 * @param movieList
	 * @param nooffavorites
	 */
	public favoritesDTO(List<movie> movieList, int nooffavorites) {
		super();
		this.movieList = movieList;
		this.nooffavorites = nooffavorites;
	}

	/**
	 * 
	 */
	public favoritesDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
