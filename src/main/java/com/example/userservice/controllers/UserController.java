package com.example.userservice.controllers;

import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;
import com.example.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserCreateRequest userCreateRequest) {
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
