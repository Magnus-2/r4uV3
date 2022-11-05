package com.kindsonthegenius.r4u.Reservation.controllers;


import com.kindsonthegenius.r4u.Reservation.models.Reservation;
import com.kindsonthegenius.r4u.Reservation.services.ReservationService;
import com.kindsonthegenius.r4u.parameters.services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class ReservationController {
	
	@Autowired private ReservationService reservationService;
	@Autowired private ClientService clientService;
	

	@GetMapping("/reservation/reservations")
	public String  getAll(Model model){
		List<Reservation> reservations =   reservationService.findAll();
		model.addAttribute("reservations", reservations);
		return "/reservation/reservations";
	}

	@GetMapping("/reservation/invoiceAdd")
	public String addInvoice(){
		return "reservation/invoiceAdd";
	}

	//The op parameter is either Edit or Details
	@GetMapping("/reservation/invoice/{op}/{id}")
	public String editInvoice(@PathVariable Integer id, @PathVariable String op, Model model){
		Reservation reservation = reservationService.findById(id);
		model.addAttribute("reservation", reservation);
		return "/reservation/reservation"+ op;
	}

	@PostMapping("/reservation/invoices")
	public String save(Reservation reservation){
		reservationService.save(reservation);
		return "redirect:/reservation/invoices";
	}

	@RequestMapping(value = "/reservation/invoices/delete/{id}", method = {RequestMethod.GET, RequestMethod.DELETE})
	public  String delete(@PathVariable Integer id){
		reservationService.delete(id);
		return "redirect:/reservation/invoices";
	}
}
