package com.example.hospital.service;

import com.example.hospital.entities.User;

public interface UserService {
    User signup(User user);

    String login(String username, String password);
}
