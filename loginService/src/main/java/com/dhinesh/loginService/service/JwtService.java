package com.dhinesh.loginService.service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {
	
	String SECRET_KEY = "23456789sdfghmdhncjv42014520015jfhdkmvbsgfjf";
	
	int JWT_VALIDITY_TIME = 900000;

	public String extractUsername(String token) {
		return extractClaims(token, Claims::getSubject);
	}
	
	public Date extractExpiration(String token) {
		return extractClaims(token, Claims::getExpiration);
	}
	
	public <T>T extractClaims(String token, Function<Claims, T> claimResolver) {
		Claims claims = extractAllClaims(token);
		return claimResolver.apply(claims);
	}

	public Claims extractAllClaims(String token) {
		return Jwts.parser()
					.verifyWith(getKey())
					.build()
					.parseSignedClaims(token)
					.getPayload();					
	}

	private SecretKey getKey() {
		byte[] keys = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keys);
	}

	public boolean validateToken(String token, UserDetails userDetails) {
		String username = extractUsername(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	public boolean isTokenExpired(String token) {
		return extractExpiration(token).before(new Date());
	}
	
	public String generateToken(String email) {
		Map<String, Object> claims = new HashMap<>();
		return createToken(email, claims);
	}
	
	public String createToken(String email, Map<String, Object> claims) {
		
		return Jwts.builder()
				.claims(claims)
				.subject(email)
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + JWT_VALIDITY_TIME))
				.signWith(getKey(), Jwts.SIG.HS256)
				.compact();
	}
}
