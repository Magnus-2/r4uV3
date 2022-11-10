package com.r4u.Restaurant.controllers;



import com.r4u.Restaurant.models.Restaurant;
import com.r4u.Restaurant.services.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Restaurant Controller manages the Apis between the HTML code
 *  and the Java code for the Class Restaurant
 */
@Controller
public class RestaurantController {
	/**
	 * Tells Spring to connect with the
	 * RestaurantService Clas
	 */
	@Autowired private RestaurantService restaurantService;

	/**
	 * Gives you back all Restaurants
	 * @param model
	 * @return
	 */
	@GetMapping("/restaurant/restaurants")
	public String  getAll(Model model){
		List<Restaurant> restaurants =   restaurantService.findAll();
		model.addAttribute("restaurants", restaurants);
		return "restaurant/restaurants";
	}

	/**
	 * Gives you back a Restaurant based on the Id
	 * @param id
	 * @return
	 */
	@GetMapping("/restaurant/restaurants/{id}")
	@ResponseBody
	public Restaurant getRestaurant(@PathVariable Integer id){
		return restaurantService.findById(id);
	}

	/**
	 * Brings you to the HTML side of restaurantAdd
	 * where you use the Save Method to add a new Restaurant
	 * @return
	 */
	@GetMapping("/restaurant/restaurantAdd")
	public String addRestaurant(){
		return "restaurant/restaurantAdd";
	}

	/**
	 * Edits a Restaurant based on the Id
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/restaurant/restaurant/Edit/{id}")
	public String editRestaurant(@PathVariable Integer id, Model model){
		Restaurant restaurant = restaurantService.findById(id);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/restaurantEdit";
	}

	/**
	 * Gives back Details of a Restaurant based on the Id
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/restaurant/restaurant/Details/{id}")
	public String detailsRestaurant(@PathVariable Integer id, Model model){
		Restaurant restaurant = restaurantService.findById(id);
		model.addAttribute("restaurant", restaurant);
		return "restaurant/restaurantDetails";
	}

	/**
	 * Saves a new Restaurant
	 * @param restaurant
	 * @return
	 */
	@PostMapping("/restaurant/restaurants")
	public String save(Restaurant restaurant){
		restaurantService.save(restaurant);
		return "redirect:/restaurant/restaurants";
	}

	/**
	 * Delets a Restaurant based on the Id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/restaurant/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		restaurantService.delete(id);
		return "redirect:/restaurant/restaurants";
	}


}
