package com.kayo.userservice.services;

import com.kayo.userservice.dto.User;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Random;

public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Spy
    private User user;

    private Random random;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);
        random = new Random();
    }

    @Test
    public void getUser_returnUser_whenSuccess() {
        int id = random.nextInt(9999999);

        User response = userService.getUser(id);

        Assert.assertNotNull(response);
    }
}
