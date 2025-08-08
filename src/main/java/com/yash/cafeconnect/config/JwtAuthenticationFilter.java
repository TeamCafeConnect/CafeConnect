package com.yash.cafeconnect.config;

import com.yash.cafeconnect.entity.enums.UserRoles;
import com.yash.cafeconnect.service.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtils jwtUtils;

    private static final Logger logger = LoggerFactory.getLogger(JwtAuthenticationFilter.class);


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        String token = extractTokenFromRequest(request);

        if (token != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            try {
                Claims claims = jwtUtils.validateToken(token);
                String email = claims.getSubject();
                String roleStr = claims.get("role", String.class);

                if (email != null && roleStr != null) {
                    UserRoles role = UserRoles.valueOf(roleStr);
                    List<GrantedAuthority> authorities = getAuthoritiesForRole(role);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(email, null, authorities);
                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            } catch (JwtException | IllegalArgumentException e) {
                logger.debug("Invalid JWT token: " + e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }

    private String extractTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

    private List<GrantedAuthority> getAuthoritiesForRole(UserRoles role) {
        List<GrantedAuthority> authorities = new ArrayList<>();

        switch (role) {
            case CUSTOMER:
                authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
                break;
            case CAFE_OWNER:
                authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_CAFE_OWNER"));
                break;
            case ADMIN:
                authorities.add(new SimpleGrantedAuthority("ROLE_CUSTOMER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_CAFE_OWNER"));
                authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                break;
        }

        return authorities;
    }
}
