package com.r4u.security.controllers;


import com.r4u.security.models.Restaurant;
import com.r4u.security.services.RestaurantService;
import com.r4u.security.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    private RoleService roleService;

    @GetMapping("/security/restaurants")
    public String getAll(Model model) {
        model.addAttribute("restaurants", restaurantService.findAll());
        return "security/restaurants";
    }

    @GetMapping("/security/restaurant/{op}/{id}")
    public String editRestaurant(@PathVariable Integer id, @PathVariable String op, Model model) {
        Restaurant restaurant = restaurantService.findById(id);
        model.addAttribute("restaurant", restaurant);
       // model.addAttribute("restaurantRoles", roleService.getUserRoles(user));
       // model.addAttribute("restaurantNotRoles", roleService.getUserNotRoles(restaurant));
        return "security/restaurant" + op; //returns employeeEdit or employeeDetails
    }

    @PostMapping("/restaurants/addNew")
    public RedirectView addNew(Restaurant restaurant, RedirectAttributes redir) {
        restaurantService.save(restaurant);

        RedirectView redirectView = new RedirectView("/login", true);
        redir.addFlashAttribute("message", "You have successfully registered a new restaurant!");
        return redirectView;
    }

}
