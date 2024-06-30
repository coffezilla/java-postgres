package com.poetutorial.poeapi.service;

import com.poetutorial.poeapi.model.User;

import java.util.List;

public interface UserService {
    void saveUser(User user);
    User findUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
    List<User> findAllUsers();
}
