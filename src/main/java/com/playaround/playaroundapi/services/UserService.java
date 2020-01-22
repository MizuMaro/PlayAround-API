package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.UserPA;

public interface UserService {
    Iterable<UserPA> getAllUsers();
    UserPA getUser(String name);
    UserPA getUserbyId(String name);
    UserPA createUser(UserPA user);
    UserPA updateUser(UserPA user);
    void deleteUser(String name);
}
