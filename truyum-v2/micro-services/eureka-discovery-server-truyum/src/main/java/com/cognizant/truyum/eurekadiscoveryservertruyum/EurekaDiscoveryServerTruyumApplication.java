package com.cognizant.truyum.eurekadiscoveryservertruyum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaDiscoveryServerTruyumApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaDiscoveryServerTruyumApplication.class, args);
	}

}
