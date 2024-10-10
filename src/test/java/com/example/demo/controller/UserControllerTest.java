package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void testCreateUser(){
        User user = new User("John", "Doe", "john.doe@gmail.com");

        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(user);
        ResponseEntity<User> response = userController.createUser(user);

        System.out.println(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(user, response.getBody());

        Mockito.verify(userService, Mockito.times(1)).saveUser(Mockito.any(User.class));
    }
}
