package com.example.userservice.entities;

import lombok.*;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Column;
import org.springframework.cloud.gcp.data.spanner.core.mapping.PrimaryKey;
import org.springframework.cloud.gcp.data.spanner.core.mapping.Table;

@Getter
@Setter
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@ToString
@Table(name = "users")
public class User {
    @PrimaryKey

    private String id;
    private String login;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;
}
