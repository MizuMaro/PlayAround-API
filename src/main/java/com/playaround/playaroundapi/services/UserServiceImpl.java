package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.UserPA;
import com.playaround.playaroundapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User.*;

import java.util.List;

@Service
class UserServiceImpl implements UserDetailsService, UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<UserPA> getAllUsers() {
        return this.userRepository.findAll();
    }

    public UserPA getUser(String name) {
        var users = this.userRepository.findAll();
        for (UserPA u : users){
            if(u.getUsername().equals(name)){
                return u;
            }
        }

        return null;
    }

    @Override
    public UserPA getUserbyId(String name) {
        var users = this.userRepository.findAll();
        for (UserPA u : users){
            if((u.getId()+"").equals(name)){
                return u;
            }
        }
        return null;
    }

    public UserPA createUser(UserPA user) {
        return this.userRepository.save(user);
    }

    @Override
    public UserPA updateUser(UserPA user) {
        return this.userRepository.save(user);
    }

    @Override
    public void addGameToFavorites(UserPA user, String gameId) {
        user.getGames().add(gameId);
    }

    @Override
    public List<String> getAllFavoriteGames(UserPA user) {
        return user.getGames();
    }

    @Override
    public void removeGameFromFavorites(UserPA user, String gameId) {
        if(user.getGames().contains(gameId)){
            user.getGames().remove(gameId);
        }
    }


    public void deleteUser(String name) {
        this.userRepository.deleteById(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserPA user = this.getUser(s);

        UserBuilder builder = null;
        if (user != null) {
            builder = org.springframework.security.core.userdetails.User.withUsername(s);
            builder.password(user.getPassword());
            builder.roles("ADMIN");
        } else {
            throw new UsernameNotFoundException("User not found.");
        }

        return builder.build();
    }
}
