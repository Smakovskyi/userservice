package com.example.userservice.entities;

import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
public class User {
    private String id;
    private String login;

    private String firstName;
    private String lastName;
}
