package com.FinMediNexus.service;

import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import com.FinMediNexus.Entity.User;
import com.FinMediNexus.security.CustomerUserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {

	

	    String extractUsername(String token);

	    <T> T extractClaim(String token, Function<Claims, T> claimsResolver);

	    String generateToken(CustomerUserDetails userDetails);

	    String generateToken(Map<String, Object> extraClaims, User user);

	    long getExpirationTime();

	    boolean isTokenValid(String token, CustomerUserDetails userDetails);

	    String extractTokenFromRequest(HttpServletRequest request);
	}

	


