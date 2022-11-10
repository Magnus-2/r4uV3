package com.r4u.security.repositories;

import com.r4u.security.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * Implements the ground functions of a Role
 * JpaRepositorys are a Addon from Spring for SQL
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

    /**
     * Gives back the Roles which a User not have from the Database
     * @param userId
     * @return
     */
    @Query(
            value = "SELECT * FROM role WHERE id NOT IN (SELECT role_id FROM user_role WHERE user_id = ?1)",
            nativeQuery = true
    )
    List<Role> getUserNotRoles(Integer userId);
}
