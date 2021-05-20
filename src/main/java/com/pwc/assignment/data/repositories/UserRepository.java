package com.pwc.assignment.data.repositories;

import com.pwc.assignment.data.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, String> {
    Optional<User> findById(String userId);

    Optional<User> findByUsername(String username);
}
