package com.example.hospital.service;

import com.example.hospital.configuration.JwtConfig;
import com.example.hospital.dao.UserRepository;
import com.example.hospital.entities.User;
import com.example.hospital.error.Error;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Service
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    private final JwtConfig jwtConfig;

    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User signup(User user) {
        user.setPassword(jwtConfig.getPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public String login(String username, String password) {
        final User user = userRepository.findByUsername(username);
        if (user == null) {
            throw Error.USER_NOT_FOUND.getBuilder().build();
        }
        if (!bCryptPasswordEncoder.matches(password, user.getPassword())) {
            throw Error.INVALID_PASSWORD.getBuilder().build();
        }
        final Key hmacKey = new SecretKeySpec(Base64.getDecoder().decode(jwtConfig.getSecret()), SignatureAlgorithm.HS256.getJcaName());

        final Instant now = Instant.now();
        return Jwts.builder().claim("name", username).setSubject(username).setId(UUID.randomUUID().toString()).setIssuedAt(Date.from(now))
                   .setExpiration(Date.from(now.plus(jwtConfig.getExpiration(), ChronoUnit.SECONDS))).signWith(hmacKey).compact();
    }
}

