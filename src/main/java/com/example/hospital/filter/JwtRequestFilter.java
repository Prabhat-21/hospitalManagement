package com.example.hospital.filter;

import com.example.hospital.configuration.JwtConfig;
import com.example.hospital.error.Error;
import com.example.hospital.utils.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor(onConstructor_ = {@Autowired})
@Component
public class JwtRequestFilter extends OncePerRequestFilter {
    private final JwtUtil jwtTokenUtil;

    private final JwtConfig jwtConfig;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String headerToken = request.getHeader(jwtConfig.getHeader());

        if (headerToken == null || !headerToken.startsWith(jwtConfig.getPrefix() + " ")) {
            throw Error.AUTH_HEADER_MISSING.getBuilder().build();
        }

        String token = headerToken.substring(7);
        String username = null;
        try {
            username = jwtTokenUtil.extractUsername(token);
        } catch (Exception e) {
            throw Error.INVALID_TOKEN.getBuilder().build();
        }
        response.addHeader("username", username);

        filterChain.doFilter(request, response);
    }
}
