package com.cf.pm.service;

import java.util.Map;
import java.util.function.Function;

import javax.servlet.http.HttpServletRequest;

import com.cf.pm.security.CustomUserDetails;

import io.jsonwebtoken.Claims;

public interface JwtService {
 
	String extractUsername(String token);

	<T> T extractClaim(String token, Function<Claims, T> claimsResolver);

	String generateToken(CustomUserDetails userDetails);

	String generateToken(Map<String, Object> extraClaims, CustomUserDetails userDetails);

	long getExpirationTime();

	boolean isTokenValid(String token, CustomUserDetails userDetails);

	String extractTokenFromRequest(HttpServletRequest request);
}
