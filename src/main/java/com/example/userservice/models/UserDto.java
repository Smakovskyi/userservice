package com.example.userservice.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserDto {
    private String identifier;
    private String login;
    private String firstName;
    private String lastName;
}
