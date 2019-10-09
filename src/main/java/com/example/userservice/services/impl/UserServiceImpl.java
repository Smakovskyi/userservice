package com.example.userservice.services.impl;

import com.example.userservice.entities.User;
import com.example.userservice.mappers.UserMapper;
import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;
import com.example.userservice.repositories.UserRepository;
import com.example.userservice.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<UserDto> findUser(String id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserDto);
    }

    @Override
    public UserDto createUser(UserCreateRequest userCreateRequest) {
        User userToSave = userMapper.userCreateRequestToUserEntity(userCreateRequest);

        User createdUser = userRepository.save(userToSave);
        return userMapper.userToUserDto(createdUser);
    }
}
