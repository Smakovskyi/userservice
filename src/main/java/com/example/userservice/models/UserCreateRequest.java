package com.example.userservice.models;

import lombok.Value;

@Value
public class UserCreateRequest {
    private String firstName;
    private String lastName;
}
