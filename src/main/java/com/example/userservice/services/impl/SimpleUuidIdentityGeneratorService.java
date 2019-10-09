package com.example.userservice.services.impl;

import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserIdentity;
import com.example.userservice.services.IdentityGeneratorService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SimpleUuidIdentityGeneratorService implements IdentityGeneratorService {
    @Override
    public UserIdentity generate(UserCreateRequest userCreateRequest) {
        String id = UUID.randomUUID().toString();
        String login = SimpleUuidIdentityGeneratorService.getLogin(userCreateRequest.getFirstName(), id);

        return new UserIdentity(id, login);
    }

    private static String getLogin(String firstName, String id) {
        String shortUniquePart = id.substring(0, id.indexOf("-"));
        return String.format("%s_%s", firstName, shortUniquePart);
    }
}
