package com.example.userservice.services;

import com.example.userservice.entities.User;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        //List<User> result = new ArrayList<>( userRepository.findAll());
        return userRepository.findAll();
       // return List.of(User.builder().id("1").login("1").build()
       //                ,User.builder().id("2").login("2").build());
    }
}
