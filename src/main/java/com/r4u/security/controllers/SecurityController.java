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

    @RequestMapping("/login")
    public String loginPage() {
        return "security/login";
    }

    @GetMapping("/register")
    public String register() {
        return "security/register";
    }

    @RequestMapping("/index")
    public String homePage() {
        return "index";
    }

    @GetMapping("/accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}
