package com.kayo.userservice.services;

import com.kayo.userservice.dto.User;
import com.kayo.userservice.repositories.UserRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;
import java.util.Random;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class UserServiceTest {
    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

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
        user.setId(id);
        user.setUsername("leomessi");
        user.setPhone("0898999");
        Optional<User> jpaResponse = Optional.of(user);
        when(userRepository.findById(any())).thenReturn(jpaResponse);

        User response = userService.getUser(id);

        Assert.assertEquals(id, response.getId());
    }
}
