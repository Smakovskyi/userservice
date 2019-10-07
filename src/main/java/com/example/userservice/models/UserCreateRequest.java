package com.example.userservice.models;

import lombok.Builder;
import lombok.Value;

@Value
@Builder
public class UserCreateRequest {
    private final String firstName;
    private final String lastName;
}
