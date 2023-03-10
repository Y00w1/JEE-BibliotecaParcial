package com.example.demo.service;

import com.example.demo.models.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    Map<String, User> getUsers();
    User getSessionUser();
    Boolean verifyCredentials(String email, String password);
    User findUser(String id);
}
