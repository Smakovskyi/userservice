package com.example.userservice.services;

import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAll();

    Optional<UserDto> findUser(String id);

    UserDto createUser(UserCreateRequest userCreateRequest);
}
