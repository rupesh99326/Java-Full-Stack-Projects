package com.cognizant.truyum.menuitemservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MenuitemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MenuitemServiceApplication.class, args);
	}

}
