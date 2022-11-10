package com.r4u.Reservation.controllers;


import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.services.ReservationService;
import com.r4u.Restaurant.services.RestaurantService;
import com.r4u.parameters.services.ClientService;
import com.r4u.security.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Reservation Controller manages the Apis between the HTML code
 * and the Java code for the Class Reservations
 */
@Controller
public class ReservationController {
	/**
	 * Tell`s Spring to connect Reservation with
	 * ReservationService
	 */
	@Autowired private ReservationService reservationService;

	/**
	 * Tell`s Spring to connect Reservation with
	 * RestaurantService
	 */
	@Autowired private RestaurantService restaurantService;

	/**
	 * Tell`s Spring to connect Reservation with
	 * UserService
	 */
	 @Autowired private UserService userService;

	/**
	 * Connects the Model Reservation, Restaurant, User with the
	 * Reservation Controller
	 * @param model
	 * @return
	 */
	public  Model addModelAttribute(Model model){
		model.addAttribute("reservations", reservationService.findAll());
		model.addAttribute("restaurants", restaurantService.findAll());
		model.addAttribute("users", userService.findAll());
		return model;
	}

	/**
	 * Gives all Reservations back
	 * @param model
	 * @return
	 */
	@GetMapping("/reservation/reservations")
	public String  findAll(Model model){
		addModelAttribute(model);
		return "reservation/reservations";
	}

	/**
	 * Adds a new Reservation
	 * @param model
	 * @return
	 */
	@GetMapping("/reservation/reservationAdd")
	public String addReservation(Model model){
		addModelAttribute(model);
		return "reservation/reservationAdd";
	}

	/**
	 * Edits a Reservation baste on the Id
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/reservation/reservations/Edit/{id}")
	public String editReservation(@PathVariable Integer id, Model model){
		addModelAttribute(model);
		model.addAttribute("reservation", reservationService.findById(id));
		return "reservation/reservationEdit";
	}

	/**
	 * Shows the Detials of a Reservation based on the Id
	 * @param id
	 * @param model
	 * @return
	 */
	@GetMapping("/reservation/reservations/Details/{id}")
	public String detailsReservation(@PathVariable Integer id, Model model){
		addModelAttribute(model);
		model.addAttribute("reservation", reservationService.findById(id));
		return "reservation/reservationDetails";
	}

	/**
	 * Saves a new Reservation
	 * @param reservation
	 * @return
	 */
	@PostMapping("/reservation/reservations")
	public String save(Reservation reservation){
		reservationService.save(reservation);
		return "redirect:/reservation/reservations";
	}

	/**
	 * Delets a Reservation based on the Id
	 * @param id
	 * @return
	 */
	@RequestMapping(value = "/reservation/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		reservationService.delete(id);
		return "redirect:/reservation/reservations";
	}


	/**
	 * Gives back your user informations
	 * @param model
	 * @return
	 */
	/*@GetMapping("/security/currentUser")
	public String currentUser(Model model){
		return "security/currentUser";
	}
	*/
}
