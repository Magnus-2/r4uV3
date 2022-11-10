package com.r4u.security.controllers;

import com.r4u.security.models.Role;
import com.r4u.security.services.RoleService;
import com.r4u.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Role Controller manages the Apis between the HTML code
 *  and the Java code for the Class Role
 */
@Controller
public class RoleController {
    /**
     * Tells Spring to connect with the
     * RoleService
     */
    @Autowired
    private RoleService roleService;
    /**
     * Tells Spring to connect with the
     * UserService
     */
    @Autowired
    private UserService userService;

    /**
     * Gives back all Roles
     * @param model
     * @return
     */
    @GetMapping("/security/roles")
    public String parameters(Model model) {
        List<Role> roles = roleService.findAll();
        model.addAttribute("roles", roles);
        return "security/roles";
    }

    /**
     * Give back a Role based on the Id
     * @param id
     * @return
     */
    @GetMapping("/security/role/{id}")
    @ResponseBody
    public Role getById(@PathVariable Integer id) {
        return roleService.findById(id);
    }

    /**
     * Save a new Role or
     * edit an old Role
     * @param role
     * @return
     */
    @PostMapping("/security/roles")
    public String save(Role role) {
        roleService.save(role);
        return "redirect:/security/roles";
    }

    /**
     * Delets a Role based on the Id
     * @param id
     * @return
     */
    @RequestMapping(value = "/security/role/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        roleService.delete(id);
        return "redirect:/security/roles";
    }

    /**
     * Assign a User based on his Id to a role based on the Role Id
     * @param userId
     * @param roleId
     * @return
     */
    @RequestMapping("/security/role/assign/{userId}/{roleId}")
    public String assignRole(@PathVariable Integer userId,
                             @PathVariable Integer roleId) {
        roleService.assignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/" + userId;
    }

    /**
     * Unassign a User based on his Id from the Role based on the Id
     * @param userId
     * @param roleId
     * @return
     */
    @RequestMapping("/security/role/unassign/{userId}/{roleId}")
    public String unassignRole(@PathVariable Integer userId,
                               @PathVariable Integer roleId) {
        roleService.unassignUserRole(userId, roleId);
        return "redirect:/security/user/Edit/" + userId;
    }
}
