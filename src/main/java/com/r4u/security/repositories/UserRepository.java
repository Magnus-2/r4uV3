package com.r4u.security.repositories;

import com.r4u.security.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Implements the ground functions of a User which
 * will be specialized by the Class Userservice
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsername(String username);

}
