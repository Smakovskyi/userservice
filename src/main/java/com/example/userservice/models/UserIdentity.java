package com.example.userservice.models;

import lombok.Value;

@Value
public class UserIdentity {
    private final String id;
    private final String login;
}
