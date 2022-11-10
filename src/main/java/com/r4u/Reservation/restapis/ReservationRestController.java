package com.r4u.Reservation.restapis;


import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ReservationRestController {

    @Autowired
    private ReservationService reservationService;

    @CrossOrigin
    @GetMapping("/Alexa")
    public List<Reservation>  getAll(Reservation reservation){
        List<Reservation> reservations =   reservationService.findAll();
        return reservations;
    }




}
