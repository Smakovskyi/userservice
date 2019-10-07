package com.example.userservice.repositories;

import com.example.userservice.entities.User;
import org.springframework.cloud.gcp.data.spanner.repository.SpannerRepository;

import java.util.List;

public interface UserRepository extends SpannerRepository<User, String> {
    @Override
    List<User> findAll();
}