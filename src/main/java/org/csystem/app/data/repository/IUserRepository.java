package org.csystem.app.data.repository;

import org.csystem.app.data.entity.User;
import org.csystem.util.data.repository.ICrudRepository;

import java.util.Optional;

interface IUserRepository extends ICrudRepository<User, Integer> {
    Optional<User> findByUsername(String username);
    Optional<User> findByEmail(String email);
    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
}
