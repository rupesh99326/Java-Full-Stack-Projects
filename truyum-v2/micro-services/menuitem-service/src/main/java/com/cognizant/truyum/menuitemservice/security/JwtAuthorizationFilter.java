package com.cognizant.truyum.menuitemservice.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.cognizant.truyum.menuitemservice.MenuitemServiceApplication;

import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;

@SuppressWarnings("hiding")
public class JwtAuthorizationFilter<Claims> extends BasicAuthenticationFilter {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuitemServiceApplication.class);

	public JwtAuthorizationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);
		LOGGER.info("Start");
		LOGGER.debug("{}: ", authenticationManager);
	}

	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		LOGGER.info("Start");
		String header = req.getHeader("Authorization");
		LOGGER.debug(header);

		if (header == null || !header.startsWith("Bearer ")) {
			chain.doFilter(req, res);
			return;
		}
		UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

		SecurityContextHolder.getContext().setAuthentication(authentication);
		chain.doFilter(req, res);
		LOGGER.info("End");
	}

	private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token != null) {
			// parse the token.
			Jws<io.jsonwebtoken.Claims> jws;
			try {
				jws = Jwts.parser().setSigningKey("secretkey").parseClaimsJws(token.replace("Bearer ", ""));
				String user = jws.getBody().getSubject();
				LOGGER.debug(user);
				if (user != null) {
					return new UsernamePasswordAuthenticationToken(user, null, new ArrayList<>());
				}
			} catch (JwtException ex) {
				return null;
			}
			return null;
		}
		return null;
	}
}
