package com.example.demo.service.impl;

import com.example.demo.models.User;
import com.example.demo.service.UserService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserServiceImpl implements UserService {
    Map<String, User> users = new HashMap<>();

    public UserServiceImpl() {
        User user = new User("david", "pas123", "email@mail.co", "myaddres", "301");
        User user2 = new User("pepe", "123", "e@c", "myaddres", "301");
        users.put(user2.getId(), user2);
        users.put(user.getId(), user);
    }

    public User sessionUser;

    public User getSessionUser() {
        return sessionUser;
    }

    @Override
    public User findUser(String id){
        for (User user : users.values()) {
            if (user.getId().equals(id)){
                return user;
            }
        }
        return null;
    }

    @Override
    public Map<String, User> getUsers() {
        return users;
    }

    @Override
    public Boolean verifyCredentials(String email, String password){
        for (User user : users.values()){
            if (user.getEmail().equals(email) && user.getPassword().equals(password)){
                sessionUser = user;
                return true;
            }
        }
        return false;
    }


}
