package com.example.userservice.services;

import com.example.userservice.entities.User;
import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;
import com.example.userservice.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {

    private static final String USER_LOGIN_TEMPLATE = "%s_%s";

    @Autowired
    private UserRepository userRepository;

    public List<UserDto> findAll() {
        return userRepository.findAll().stream()
                .map(UserService::toUserDto)
                .collect(Collectors.toList());
    }

    public Optional<UserDto> findUser(String id) {
        return userRepository.findById(id)
                .map(UserService::toUserDto);
    }

    public UserDto createUser(UserCreateRequest userCreateRequest) {
        String uuid = UUID.randomUUID().toString();
        String login = UserService.getLogin(userCreateRequest.getFirstName(), uuid);

        User userToSave = User.builder()
                .id(uuid)
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .login(login)
                .build();

        User createdUser = userRepository.save(userToSave);
        return toUserDto(createdUser);
    }

    private static String getLogin(String firstName, String uuid) {
        String uniquePart = uuid.substring(0, uuid.indexOf("-"));
        return String.format(USER_LOGIN_TEMPLATE, firstName, uniquePart);
    }

    private static UserDto toUserDto(User user) {
        return UserDto.builder()
                .identifier(user.getId())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .login(user.getLogin())
                .build();
    }
}
