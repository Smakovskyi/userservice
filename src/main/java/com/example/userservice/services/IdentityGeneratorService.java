package com.example.userservice.services;

import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserIdentity;

public interface IdentityGeneratorService {
    UserIdentity generate(UserCreateRequest userCreateRequest);
}
