package com.cognizant.moviecruiser.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movie;

public class FavoritesDaoSqlImpl implements FavoritesDao {

	public void addFavoritesItem(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement ps = con.prepareStatement("select * from user where us_id=?");
			ps.setLong(1, userId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				PreparedStatement ps1 = con
						.prepareStatement("INSERT INTO `favorites` (`fvt_us_id`,`fvt_mov_id`) values(?,?)");
				ps1.setLong(1, userId);
				ps1.setLong(2, movieId);
				ps1.executeUpdate();
			}

			else {
				PreparedStatement ps2 = con.prepareStatement("INSERT INTO `user` (`us_id`,`us_name`) values(?,'Ravi')");
				ps2.setLong(1, userId);

				PreparedStatement ps3 = con
						.prepareStatement("INSERT INTO `favorites` (`fvt_us_id`,`fvt_mov_id`) values(?,?)");
				ps3.setLong(1, userId);

				ps3.setLong(2, movieId);
				ps2.executeUpdate();
				ps3.executeUpdate();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public Favorites getAllFavoritesItems(long userId) throws FavoritesEmptyException {
		Connection con = ConnectionHandler.getConnection();
		Favorites c1 = null;

		try {

			PreparedStatement prToMovie, prToFavorites;
			PreparedStatement prToSelectTotalPrice;
			ResultSet ras, resultSetFavorites;
			ResultSet ras_Total;

			prToFavorites = con.prepareStatement("select * from favorites where fvt_us_id=?");
			prToFavorites.setLong(1, userId);

			List<Movie> m1 = new ArrayList<Movie>();
			c1 = new Favorites(m1, 0);
			resultSetFavorites = prToFavorites.executeQuery();
			boolean boolCheckFavorites = resultSetFavorites.next();
			System.out.println("boolCheckFavorites: " + boolCheckFavorites);
			if (!boolCheckFavorites) {
				throw new FavoritesEmptyException();
			}
			prToMovie = con.prepareStatement(
					"select `movie_item`.* from `movie_item` join `favorites` on `movie_item`.`mo_id`=`favorites`.`fvt_mov_id` where `favorites`.`fvt_us_id`=?");
			prToMovie.setLong(1, userId);

			ras = prToMovie.executeQuery();
			while (ras.next()) {
				Movie movie = new Movie(ras.getLong(1), ras.getString(2), ras.getLong(3),
						ras.getString(4).equals("yes") ? true : false, ras.getDate(5), ras.getString(6),
						ras.getString(7).equals("yes") ? true : false);
				m1.add(movie);
			}
			prToSelectTotalPrice = con
					.prepareStatement("select COUNT(fvt_mov_id) FROM favorites where `favorites`.fvt_us_id=?");
			prToSelectTotalPrice.setLong(1, userId);

			ras_Total = prToSelectTotalPrice.executeQuery();
			while (ras_Total.next()) {
				c1.setNooffavorites(ras_Total.getInt(1));
			}
			c1.setMovieList(m1);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				con.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return c1;
	}

	public void removeFavoritesItem(long userId, long movieId) {
		Connection con = ConnectionHandler.getConnection();
		try {

			PreparedStatement ps6 = con
					.prepareStatement("DELETE FROM favorites WHERE fvt_us_id=? AND fvt_mov_id=? LIMIT 1");
			ps6.setLong(1, userId);
			ps6.setLong(2, movieId);
			ps6.executeUpdate();
		} catch (Exception e) {
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
