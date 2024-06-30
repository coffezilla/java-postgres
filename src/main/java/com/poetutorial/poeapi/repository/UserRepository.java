package com.poetutorial.poeapi.repository;

import com.poetutorial.poeapi.model.User;

public interface UserRepository {
    void saveUser(User user);
    User findUserById(Long id);
    void updateUser(User user);
    void deleteUser(Long id);

}
