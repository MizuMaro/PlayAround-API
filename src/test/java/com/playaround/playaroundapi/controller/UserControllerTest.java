package com.playaround.playaroundapi.controller;

import com.playaround.playaroundapi.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;

public class UserControllerTest {


    @Mock
    private UserService service;

    @InjectMocks
    private UserController controler;

    @BeforeEach
    void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void getAllUsers_shouldCallTheService() {
        controler.getAllUsers();

        verify(service).getAllUsers();
    }


    @Test
    void getAllUsers_shouldBeAnnotated() throws NoSuchMethodException {
        var getAllTrainers =
                UserController.class.getDeclaredMethod("getAllUsers");
        var getMapping = getAllTrainers.getAnnotation(GetMapping.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{}, getMapping.value());
    }

    @Test
    void getUser_shouldBeAnnotated() throws NoSuchMethodException {
        var getTrainer =
                UserController.class.getDeclaredMethod("getUser", String.class);
        var getMapping = getTrainer.getAnnotation(GetMapping.class);

        var pathVariableAnnotation = getTrainer.getParameters()[0].getAnnotation(PathVariable.class);

        assertNotNull(getMapping);
        assertArrayEquals(new String[]{"/{name}"}, getMapping.value());

        assertNotNull(pathVariableAnnotation);
    }
}
