package com.r4u.Reservation.controllers;


import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.services.ReservationService;
import com.r4u.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ReservationController {
	
	@Autowired private ReservationService reservationService;
	

	@GetMapping("/reservation/reservations")
	public String  getAll(Model model){
		List<Reservation> reservations =   reservationService.findAll();
		model.addAttribute("reservations", reservations);
		return "reservation/reservations";
	}

	@GetMapping("/reservation/reservationAdd")
	public String addReservation(){
		return "reservation/reservationAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/reservation/reservationEdit/{id}")
	public String editReservation(@PathVariable Integer id, Model model){
		Reservation reservation = reservationService.findById(id);
		model.addAttribute("reservation", reservation);
		return "reservation/reservationEdit";
	}

	@GetMapping("/reservation/reservations/Details/{id}")
	public String detailsReservation(@PathVariable Integer id, Model model){
		Reservation reservation = reservationService.findById(id);
		model.addAttribute("reservation", reservation);
		return "reservation/reservationDetails";
	}

	@PostMapping("/reservation/reservations")
	public String save(Reservation reservation){
		reservationService.save(reservation);
		return "redirect:reservation/reservations";
	}

	@RequestMapping(value = "/reservation/reservations/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		reservationService.delete(id);
		return "redirect:reservation/reservations";
	}
}
