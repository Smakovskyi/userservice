package com.example.userservice.services;

import com.example.userservice.entities.User;
import com.example.userservice.mappers.UserMapper;
import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;
import com.example.userservice.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findUser(String id) {
        return userRepository.findById(id)
                .map(userMapper::userToUserDto);
    }

    public UserDto createUser(UserCreateRequest userCreateRequest) {
        User userToSave = userMapper.userCreateRequestToUserEntity(userCreateRequest);

        User createdUser = userRepository.save(userToSave);
        return userMapper.userToUserDto(createdUser);
    }
}
