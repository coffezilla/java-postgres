package com.poetutorial.poeapi.repository;

import com.poetutorial.poeapi.model.User;

import java.util.List;

public interface UserRepository {
    void saveUser(User user);
    User findUserById(Long id);
    User updateUser(User user);
    void deleteUser(Long id);
    List<User> findAllUsers();
}
