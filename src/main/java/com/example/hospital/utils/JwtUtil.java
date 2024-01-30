package com.example.hospital.utils;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.example.hospital.configuration.JwtConfig;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor (onConstructor_ = { @Autowired })
@Component
public class JwtUtil {
    private final JwtConfig jwtConfig;

    public String generateToken(String username) {
        return Jwts.builder().setSubject(username).setExpiration(new Date(System.currentTimeMillis() + jwtConfig.getExpiration()))
                   .signWith(SignatureAlgorithm.HS512, jwtConfig.getSecret()).compact();
    }

    public String extractUsername(String token) {
        return Jwts.parser().setSigningKey(jwtConfig.getSecret()).parseClaimsJws(token).getBody().getSubject();
    }
}