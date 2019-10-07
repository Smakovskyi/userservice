package com.example.userservice.mappers;

import com.example.userservice.entities.User;
import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.UUID;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "id", target = "identifier")
    UserDto userToUserDto(User source);

    default User userCreateRequestToUserEntity(UserCreateRequest userCreateRequest) {
        String uuid = UUID.randomUUID().toString();
        String login = UserMapper.getLogin(userCreateRequest.getFirstName(), uuid);

        return User.builder()
                .id(uuid)
                .firstName(userCreateRequest.getFirstName())
                .lastName(userCreateRequest.getLastName())
                .login(login)
                .build();
    }

    private static String getLogin(String firstName, String uuid) {
        String uniquePart = uuid.substring(0, uuid.indexOf("-"));
        return String.format("%s_%s", firstName, uniquePart);
    }
}
