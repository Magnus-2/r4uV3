package com.r4u.security.controllers;

import com.r4u.Restaurant.models.Restaurant;
import com.r4u.security.models.User;
import com.r4u.security.services.RoleService;
import com.r4u.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

/**
 * User Controller manages the Apis between the HTML code
 * and the Java code for the Class User
 */
@Controller
public class UserController {
    /**
     * Tells Spring to connect with
     * the UserService
     */
    @Autowired
    private UserService userService;
    /**
     * Tells SPring to connect with
     * the RoleService
     */
    @Autowired
    private RoleService roleService;

    /**
     * Gives back all Users
     * @param model
     * @return
     */
    @GetMapping("/security/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "security/users";
    }

    /**
     * Get a User based on the Id
     * @param id
     * @return
     */
    @GetMapping("/security/users/{id}")
    @ResponseBody
    public User getUser(@PathVariable Integer id){
        return userService.findById(id);
    }

    /**
     * The {op} stands for Operation
     * this Method is for Edit and Details
     * based on the op one is choosen and gives back a
     * User to Edit or to see the Details based on the Id
     * @param id
     * @param op
     * @param model
     * @return
     */
    @GetMapping("/security/user/{op}/{id}")
    public String editUser(@PathVariable Integer id, @PathVariable String op, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "security/user" + op; //returns employeeEdit or employeeDetails
    }

    /**
     * Adds a new user
     * or saves an edited user
     * @param user
     * @param redir
     * @return
     */
    @PostMapping("/users/addNew")
    public RedirectView addNew(User user, RedirectAttributes redir) {
        userService.save(user);

        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "You have successfully registered a new user!");
        return redirectView;
    }

    /**
     * Delets a user based on the Id
     * @param id
     * @return
     */
    @RequestMapping(value = "/security/user/delete/{id}", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(@PathVariable Integer id) {
        userService.delete(id);
        return "redirect:/security/users";
    }


    /**
     * Gives back your user informations
     * @param model
     * @return
     */
    @GetMapping("/security/currentUser")
    public String currentUser(Model model){
        return "security/currentUser";
    }
}
