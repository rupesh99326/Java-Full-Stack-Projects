package com.cognizant.moviecruiser.eurekadiscoveryservermoviecruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServerMoviecruiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryServerMoviecruiserApplication.class, args);
	}

}
