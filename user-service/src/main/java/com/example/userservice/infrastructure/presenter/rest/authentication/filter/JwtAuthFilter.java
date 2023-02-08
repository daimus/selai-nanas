package com.example.userservice.infrastructure.presenter.rest.authentication.filter;

import com.example.userservice.infrastructure.presenter.rest.authentication.dto.AuthenticatedUser;
import com.example.userservice.infrastructure.presenter.rest.authentication.service.CustomUserDetailService;
import com.example.userservice.infrastructure.presenter.rest.authentication.util.JwtUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthFilter extends OncePerRequestFilter {
    private final CustomUserDetailService customUserDetailService;
    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException, IOException {

        String authorizationHeader = httpServletRequest.getHeader("Authorization");

        String token = null;
        Long userId = null;
        String userName = null;
        String userRole = null;

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            userId = Long.valueOf(jwtUtil.extractUserId(token));
            userName = jwtUtil.extractUsername(token);
            userRole = jwtUtil.extractRole(token);
        }

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            UserDetails userDetails = new AuthenticatedUser(userName, "", customUserDetailService.getAuthorities(userRole), userId);
            if (jwtUtil.validateToken(token, userId)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(httpServletRequest));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
