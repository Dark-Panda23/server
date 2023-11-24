package org.example.service;


import org.example.model.User;

public interface UserService {

    boolean createUser(User user);

    User findUserByEmail(String email);
}