package com.cognizant.moviecruiser.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.moviecruiser.model.movie;

public interface MovieItemRepository extends JpaRepository<movie,Long>{

	
	
	
	@Query("From movie m where m.active=1 and m.Date_of_Launch<CURDATE()")
    List<movie> getMenuItemCustomer();

	


}
