package com.cognizant.moviecruiser.controller;


import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.moviecruiser.model.Users;
import com.cognizant.moviecruiser.repository.UserRepository;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthenticationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);
	@Autowired
	UserRepository UserRepository;
	@GetMapping("/authenticate")
	public Map<String, String> authenticate(@RequestHeader("Authorization") String authHeader) {
		LOGGER.info("Start of auth function");
		LOGGER.info(authHeader);
		Map<String, String> authmap = new HashMap<String, String>();
		authmap.put("token", generateJwt((getUser(authHeader))));

		String username =  getUser(authHeader);
		authmap.put("username", username);
		Users user = UserRepository.findByUsername(username);
		String role = user.getRoles().get(0).getName();
		String firstname = user.getFirstname();
		String lastname = user.getLastname();
		authmap.put("role", role);
		authmap.put("firstname", firstname);
		authmap.put("lastname", lastname);
		LOGGER.info("END OF AUTH FUNCTION");
		return authmap;
	}

	private String getUser(String authHeader) {
		String encodedCredentials = authHeader.split(" ", 2)[1];
		String decoded = new String(Base64.getDecoder().decode(encodedCredentials));
		String user = decoded.substring(0, decoded.indexOf(':'));
		return user;
	}

	private String generateJwt(String user) {
		JwtBuilder builder = Jwts.builder();
		builder.setSubject(user);

		// Set the token issue time as current time
		builder.setIssuedAt(new Date());

		// Set the token expiry as 20 minutes from now
		builder.setExpiration(new Date((new Date()).getTime() + 1200000));
		builder.signWith(SignatureAlgorithm.HS256, "secretkey");

		String token = builder.compact();
		LOGGER.info(token);
		return token;
	}

}
