package com.kayo.userservice.services;

import com.kayo.userservice.dto.User;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    public User getUser(int id) {
        return new User();
    }
}
