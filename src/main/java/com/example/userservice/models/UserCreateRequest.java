package com.example.userservice.models;

import lombok.Value;

import javax.validation.constraints.NotBlank;

@Value
public class UserCreateRequest {
    @NotBlank
    private final String firstName;
    @NotBlank
    private final String lastName;
}
