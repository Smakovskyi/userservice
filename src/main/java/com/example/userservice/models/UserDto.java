package com.example.userservice.models;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Value;

@Value
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE) // for MapStruct
public class UserDto {
    private final String identifier;
    private final String login;
    private final String firstName;
    private final String lastName;
}
