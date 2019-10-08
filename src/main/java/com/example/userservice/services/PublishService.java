package com.example.userservice.services;

import com.example.userservice.entities.User;
import com.example.userservice.pubsub.PubSubConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PublishService {
    @Autowired
    private PubSubConfiguration.PubsubOutboundGateway messagingGateway;

    public void userCreated(User user){
        messagingGateway.sendToPubsub(user.toString());
    }
}
