package com.kayo.userservice.controllers;

import com.kayo.userservice.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    @Test
    public void getUser_return200_whenRequestCorrect() throws Exception {
        mockMvc.perform(get("/users/101"))
                .andExpect(status().isOk());
    }
}
