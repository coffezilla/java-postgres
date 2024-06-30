package com.poetutorial.poeapi.service;

import com.poetutorial.poeapi.model.User;

public interface UserService {
    void saveUser(User user);
    User findUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);

}
