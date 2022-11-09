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


@Controller
public class ReservationController {
	
	@Autowired private ReservationService reservationService;
	@Autowired private RestaurantService restaurantService;
	 @Autowired private UserService userService;


	public  Model addModelAttribute(Model model){
		model.addAttribute("reservations", reservationService.findAll());
		model.addAttribute("restaurants", restaurantService.findAll());
		model.addAttribute("users", userService.findAll());
		return model;
	}

	@GetMapping("/reservation/reservations")
	public String  findAll(Model model){
		addModelAttribute(model);
		//List<Reservation> reservations =   reservationService.findAll();
		//model.addAttribute("reservations", reservations);
		return "reservation/reservations";
	}

	@GetMapping("/reservation/reservationAdd")
	public String addReservation(Model model){
		addModelAttribute(model);
		return "reservation/reservationAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/reservation/reservations/Edit/{id}")
	public String editReservation(@PathVariable Integer id, Model model){
		addModelAttribute(model);
		model.addAttribute("reservation", reservationService.findById(id));
		return "reservation/reservationEdit";
	}

	@GetMapping("/reservation/reservations/Details/{id}")
	public String detailsReservation(@PathVariable Integer id, Model model){
		addModelAttribute(model);
		model.addAttribute("reservation", reservationService.findById(id));
		//Reservation reservation = reservationService.findById(id);
		//model.addAttribute("reservation", reservation);
		return "/reservation/reservationDetails";
	}

	@PostMapping("/reservation/reservations")
	public String save(Reservation reservation){
		reservationService.save(reservation);
		return "redirect:/reservation/reservations";
	}

	@RequestMapping(value = "/reservation/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		reservationService.delete(id);
		return "redirect:/reservation/reservations";
	}
}
