package com.r4u.Restaurant.controllers;



import com.r4u.Restaurant.models.Restaurant;
import com.r4u.Restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class RestaurantController {
	
	@Autowired private RestaurantService restaurantService;
	

	@GetMapping("/restaurant/restaurants")
	public String  getAll(Model model){
		List<Restaurant> restaurants =   restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);// hier vielleicht restaurants
		return "restaurant/restaurants";
	}

	@GetMapping("/restaurant/restaurantAdd")
	public String addRestaurant(){
		return "restaurant/restaurantAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/restaurant/restaurant/Edit/{id}")
	public String editRestaurant(@PathVariable Integer id, Model model){
		Restaurant restaurant = restaurantService.findById(id);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/restaurantEdit";
	}

	@GetMapping("/restaurant/restaurant/Details/{id}")
	public String detailsRestaurant(@PathVariable Integer id, Model model){
		Restaurant restaurant = restaurantService.findById(id);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/restaurantDetails";
	}

	@PostMapping("/restaurant/restaurants")
	public String save(Restaurant restaurant){
		restaurantService.save(restaurant);
		return "redirect:/restaurant/restaurants";
	}

	@RequestMapping(value = "/restaurant/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		restaurantService.delete(id);
		return "redirect:/restaurant/restaurants";
	}


}
