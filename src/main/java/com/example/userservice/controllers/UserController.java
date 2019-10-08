package com.example.userservice.controllers;

import com.example.userservice.entities.User;
import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;
import com.example.userservice.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(UserCreateRequest userCreateRequest) {
        UserDto createdUser = userService.createUser(userCreateRequest);

        URI location = URI.create(String.format("/api/users/%s", createdUser.getIdentifier()));
        return ResponseEntity.created(location)
                .body(createdUser);
    }

    @GetMapping("{id}")
    public ResponseEntity<UserDto> findUser(@PathVariable("id") String id) {
        return userService.findUser(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

}
