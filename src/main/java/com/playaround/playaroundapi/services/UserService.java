package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.User;

public interface UserService {
    Iterable<User> getAllUsers();
    User getUser(String name);
    User createUser(User user);

    void deleteUser(String name);
}
