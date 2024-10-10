package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void testCreateUser() {
        //Given
        User user = new User("John", "Doe", "john.doe@gmail.com");
        Mockito.when(userService.saveUser(Mockito.any(User.class))).thenReturn(user);
        //When
        userController.createUser(user);
        //Then
        Mockito.verify(userService, Mockito.times(1)).saveUser(Mockito.any(User.class));
    }
}
