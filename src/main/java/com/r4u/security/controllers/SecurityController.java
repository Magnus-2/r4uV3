package com.r4u.security.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Security Controller manages the Apis between the HTML code
 * and the Java code for the Class Scurity
 */
@Controller
public class SecurityController {
    /**
     * Displays the Login page
     * @return
     */
    @RequestMapping("/login")
    public String loginPage() {
        return "security/login";
    }

    /**
     * Gives back the Registrationform
     * @return
     */
    @GetMapping("/register")
    public String register() {
        return "security/register";
    }

    /**
     * Gives back the Home Page
     * @return
     */
    @RequestMapping("/index")
    public String homePage() {
        return "index";
    }

    /**
     * Shows the Acces Denied page when
     * you have not the Permissions to see a page
     * @return
     */
    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
