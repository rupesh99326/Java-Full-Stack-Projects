package com.cognizant.truyum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.model.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{

public Users findByUsername(String username);


@Query("SELECT u.menuItems from Users u WHERE u.username=?1")
List<MenuItem> getMenuItems(String username);


@Query(value = "select sum(me_price) from menu_item where me_id in(select ct_pr_id from cart where ct_us_id=(select us_id from user where us_username= :username))", nativeQuery = true)
public double getCartTotal(@Param(value = "username") String username);

}
