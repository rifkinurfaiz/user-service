package com.kayo.userservice.controllers;

import com.kayo.userservice.dto.User;
import com.kayo.userservice.dto.request.UserRequest;
import com.kayo.userservice.services.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class UserControllerTest {
    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    private MockMvc mockMvc;

    private Random random;

    @Before
    public void init() {
        MockitoAnnotations.openMocks(this);

        this.mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
        random = new Random();
    }

    @Test
    public void getUser_return200_whenRequestCorrect() throws Exception {
        int id = random.nextInt(9999999);
        mockMvc.perform(get("/users/"+id))
                .andExpect(status().isOk());
    }

    @Test
    public void submitUser_return200_whenRequestCorrect() throws Exception {
        mockMvc.perform(post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"username\": \"leomessi\", \"firstName\": \"leo\", \"lastName\": \"messi\", \"phone\": \"08989999\"}")
                ).andExpect(status().isOk());
    }
}
