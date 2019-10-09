package com.example.userservice.services;

import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserIdentity;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class IdentityGeneratorService {
    public UserIdentity generate(UserCreateRequest userCreateRequest) {
        String id = UUID.randomUUID().toString();
        String login = IdentityGeneratorService.getLogin(userCreateRequest.getFirstName(), id);

        return new UserIdentity(id, login);
    }

    private static String getLogin(String firstName, String id) {
        String shortUniquePart = id.substring(0, id.indexOf("-"));
        return String.format("%s_%s", firstName, shortUniquePart);
    }
}
