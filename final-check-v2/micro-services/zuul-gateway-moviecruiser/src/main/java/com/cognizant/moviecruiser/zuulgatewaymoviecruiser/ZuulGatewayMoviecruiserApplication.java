package com.cognizant.moviecruiser.zuulgatewaymoviecruiser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayMoviecruiserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayMoviecruiserApplication.class, args);
	}

}
