package com.example.graphqlservice.repository;

import com.example.graphqlservice.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by scottmcallister on 2018-02-16.
 */
public interface UserRepository extends CrudRepository<User, Long> {
    User findByHandle(String handle);
}
