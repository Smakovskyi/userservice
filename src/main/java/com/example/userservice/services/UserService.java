package com.example.userservice.services;

import com.example.userservice.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    public List<User> findAll() {
        return List.of(User.builder().id("1").login("1").build()
                       ,User.builder().id("2").login("2").build());
    }
}
