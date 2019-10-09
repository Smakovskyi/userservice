package com.example.userservice.mappers;

import com.example.userservice.entities.User;
import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
@DecoratedWith(UserEntityWithIdentityFieldsDecorator.class)
public interface UserMapper {
    @Mapping(source = "id", target = "identifier")
    UserDto userToUserDto(User source);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "login", ignore = true)
    User userCreateRequestToUserEntity(UserCreateRequest source);
}
