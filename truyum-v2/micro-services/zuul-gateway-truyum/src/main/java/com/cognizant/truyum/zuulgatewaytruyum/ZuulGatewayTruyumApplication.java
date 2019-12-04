package com.cognizant.truyum.zuulgatewaytruyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
public class ZuulGatewayTruyumApplication {

	public static void main(String[] args) {
		SpringApplication.run(ZuulGatewayTruyumApplication.class, args);
	}

}
