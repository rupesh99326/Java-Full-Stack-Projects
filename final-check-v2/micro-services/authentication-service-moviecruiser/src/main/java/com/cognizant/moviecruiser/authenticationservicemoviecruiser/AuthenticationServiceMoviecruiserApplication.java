package com.cognizant.moviecruiser.authenticationservicemoviecruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AuthenticationServiceMoviecruiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationServiceMoviecruiserApplication.class, args);
	}

}
