package com.yash.cafeconnect.service;

import com.yash.cafeconnect.entity.enums.UserRoles;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.List;

@Service
public class JwtUtils {

    private final Key SECRET_KEY = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 12; // 12 hours valid

    public String generateToken(String email, UserRoles role) {
        return Jwts.builder()
                .setSubject(email)
                .claim("role", role)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
                .compact();
    }

    public Claims validateToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateTokenForUser(String token, String email) {
        try {
            Claims claims = validateToken(token);
            String tokenEmail = claims.getSubject();
            return (email.equals(tokenEmail) && !isTokenExpired(claims));
        } catch (JwtException e) {
            return false;
        }
    }

    public boolean validateTokenForRoles(String token, List<UserRoles> userRoles) {
        try {
            Claims claims = validateToken(token);
            String tokenRoleStr = claims.get("role", String.class);
            if (tokenRoleStr == null) return false;
            UserRoles tokenRole = UserRoles.valueOf(tokenRoleStr);
            return userRoles.contains(tokenRole);
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    private boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}