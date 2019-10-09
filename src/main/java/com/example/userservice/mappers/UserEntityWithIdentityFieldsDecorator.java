package com.example.userservice.mappers;

import com.example.userservice.entities.User;
import com.example.userservice.models.UserCreateRequest;
import com.example.userservice.models.UserIdentity;
import com.example.userservice.services.IdentityGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

abstract class UserEntityWithIdentityFieldsDecorator implements UserMapper {
    @Autowired
    @Qualifier("delegate")
    private UserMapper delegate;

    @Autowired
    private IdentityGeneratorService identityGeneratorService;

    @Override
    public User userCreateRequestToUserEntity(UserCreateRequest source) {
        UserIdentity userIdentity = identityGeneratorService.generate(source);

        User userToPopulateWithIdentityFields = delegate.userCreateRequestToUserEntity(source);
        userToPopulateWithIdentityFields.setId(userIdentity.getId());
        userToPopulateWithIdentityFields.setLogin(userIdentity.getLogin());
        return userToPopulateWithIdentityFields;
    }
}
