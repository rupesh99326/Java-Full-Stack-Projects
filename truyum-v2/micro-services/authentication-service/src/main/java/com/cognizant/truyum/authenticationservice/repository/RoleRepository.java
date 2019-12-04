package com.cognizant.truyum.authenticationservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.truyum.authenticationservice.model.Role;

public interface RoleRepository extends JpaRepository<Role,Integer>{

}
