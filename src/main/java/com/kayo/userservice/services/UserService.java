package com.kayo.userservice.services;

import com.kayo.userservice.dto.User;
import com.kayo.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUser(int id) {
        Optional<User> user = userRepository.findById(id);

        return user.get();
    }
}
