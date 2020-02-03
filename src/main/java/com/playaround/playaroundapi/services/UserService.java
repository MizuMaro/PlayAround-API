package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.UserPA;

import java.util.List;

public interface UserService {
    Iterable<UserPA> getAllUsers();
    UserPA getUser(String name);
    UserPA getUserbyId(String name);
    UserPA createUser(UserPA user);
    UserPA updateUser(UserPA user);
    void addGameToFavorites(UserPA user, String gameId);
    List<String> getAllFavoriteGames(UserPA user);
    void removeGameFromFavorites(UserPA user, String gameId);
    void deleteUser(String name);
}
