package com.cognizant.moviecruiser.movieservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.moviecruiser.movieservice.model.Users;
import com.cognizant.moviecruiser.movieservice.model.movie;

public interface UserRepository extends JpaRepository<Users,Integer>{

public Users findByUsername(String username);


@Query("SELECT u.movieItems from Users u WHERE u.username=?1")
List<movie> getMovieItems(String username);

//
//@Query(value = "select sum(me_price) from movie_item where mo_id in(select fvt_mov_id from favorites where ct_us_id=(select us_id from user where us_username= :username))", nativeQuery = true)
//public double getFavoritesTotal(@Param(value = "username") String username);

}
