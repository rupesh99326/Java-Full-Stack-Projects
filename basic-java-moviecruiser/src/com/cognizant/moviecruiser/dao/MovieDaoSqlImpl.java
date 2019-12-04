package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Movie;

public class MovieDaoSqlImpl implements MovieDao {

	public List<Movie> getMovieListAdmin() {
		Connection con = ConnectionHandler.getConnection();
		List<Movie> ls = new ArrayList<Movie>();
		try {

			PreparedStatement ps = con.prepareStatement("select * from movie_item");

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				Movie movie = new Movie(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
				ls.add(movie);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return ls;

	}

	public List<Movie> getMovieListCustomer() {

		Connection con = ConnectionHandler.getConnection();
		List<Movie> lst = new ArrayList<Movie>();
		try {

			PreparedStatement ps = con.prepareStatement(
					"SELECT * from movie_item where mo_active=1 and mo_date_of_launch<=curdate()");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Movie movie = new Movie(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
				lst.add(movie);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lst;
	}

	public Movie getMovie(long movieId) {
		Connection con = ConnectionHandler.getConnection();
		Movie mo = null;
		try {

			PreparedStatement ps = con.prepareStatement("select * from movie_item where mo_id=?");
			ps.setLong(1, movieId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				mo = new Movie(rs.getLong(1), rs.getString(2), rs.getLong(3), rs.getBoolean(4), rs.getDate(5),
						rs.getString(6), rs.getBoolean(7));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mo;
	}

	public void modifyMovie(Movie movie) {
		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement ps;

			ps = con.prepareStatement(
					"UPDATE `moviecruiser`.`movie_item` SET `mo_title`=?, `mo_boxoffice`=?, `mo_active`=?,`mo_date_of_launch`=?,`mo_genre`=?,`mo_hasteaser`=?  WHERE `mo_id`=?");
			ps.setString(1, movie.gettitle());
			ps.setFloat(2, movie.getBoxoffice());
			ps.setBoolean(3, movie.isActive());
			Date da = new Date(movie.getDateOfLaunch().getTime());
			ps.setDate(4, da);
			ps.setString(5, movie.getGenre());
			ps.setBoolean(6, movie.isHasteaser());
			ps.setLong(7, movie.getId());
			ps.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
