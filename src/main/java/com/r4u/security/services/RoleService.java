package com.r4u.security.services;

import com.r4u.security.models.Role;
import com.r4u.security.models.User;
import com.r4u.Restaurant.repositories.RestaurantRepository;
import com.r4u.security.repositories.RoleRepository;
import com.r4u.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
/**
 * The Role Service specialise the functions
 * which you can use to get Data for example
 */
@Service
public class RoleService {
    /**
     * Tells Spring to connect with
     * RoleRepository
     */
    @Autowired
    private RoleRepository roleRepository;
    /**
     * Tells SPring to connect with
     * UserRepository
     */
    @Autowired
    private UserRepository userRepository;
    /**
     * Tells SPring to connect with
     * RestaurantRepository
     */
    @Autowired
    private RestaurantRepository restaurantRepository;

    /**
     * Gives back all Roles
     * @return
     */
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    /**
     * Gives back a Role based on Id
     * @param id
     * @return
     */
    public Role findById(int id) {
        return roleRepository.findById(id).orElse(null);
    }

    /**
     * Delets a Role
     * @param id
     */
    public void delete(int id) {
        roleRepository.deleteById(id);
    }

    /**
     * Saves or Edit a Role
     * @param role
     */
    public void save(Role role) {
        roleRepository.save(role);
    }

    /**
     * Assign a User to a Role
     * @param userId
     * @param roleId
     */
    public void assignUserRole(Integer userId, Integer roleId) {
        User user = userRepository.findById(userId).orElse(null);
        Role role = roleRepository.findById(roleId).orElse(null);
        Set<Role> userRoles = user.getRoles();
        userRoles.add(role);
        user.setRoles(userRoles);
        userRepository.save(user);
    }

    /**
     *  Unassign a Role to a User
     */
    public void unassignUserRole(Integer userId, Integer roleId) {
        User user = userRepository.findById(userId).orElse(null);
        user.getRoles().removeIf(x -> x.getId() == roleId);
        userRepository.save(user);
    }

    /**
     * Gives back the Roles of a User
     * @param user
     * @return
     */
    public Set<Role> getUserRoles(User user) {
        return user.getRoles();
    }

    /**
     * Gives back all Roles which a User does not have
     * @param user
     * @return
     */
    public List<Role> getUserNotRoles(User user) {
        return roleRepository.getUserNotRoles(user.getId());
    }


}
