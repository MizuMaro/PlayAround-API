package com.playaround.playaroundapi.services;

import com.playaround.playaroundapi.bo.SessionPA;
import com.playaround.playaroundapi.bo.UserPA;
import com.playaround.playaroundapi.repository.SessionRepository;
import com.playaround.playaroundapi.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserServiceImplTest {

    @Test
    void getAllUsers_shouldCallTheRepository() {
        var userRepo = mock(UserRepository.class);
        var userService = new UserServiceImpl(userRepo);

        userService.getAllUsers();

        verify(userRepo).findAll();
    }

    @Test
    void createUser_shouldCallTheRepository() {
        var userRepo = mock(UserRepository.class);
        var userService = new UserServiceImpl(userRepo);


        var user = new UserPA();
        userService.createUser(user);

        verify(userRepo).save(user);
    }

}
