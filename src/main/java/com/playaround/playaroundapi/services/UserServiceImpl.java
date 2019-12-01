package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.User;
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

    public Iterable<User> getAllUsers() {
        return this.userRepository.findAll();
    }

    public User getUser(String name) {
        var users = this.userRepository.findAll();
        for (User u : users){
            if(u.getUsername().equals(name)){
                return u;
            }
        }

        return null;
    }

    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    public void deleteUser(String name) {
        this.userRepository.deleteById(name);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = this.getUser(s);

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
