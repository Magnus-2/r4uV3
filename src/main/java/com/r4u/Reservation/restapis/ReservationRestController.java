package com.r4u.Reservation.restapis;


import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Is only for communication with Alexa
 */
@RestController
public class ReservationRestController {
    /**
     * Tells Springt to connect with die class
     * Reservation Service
     */
    @Autowired
    private ReservationService reservationService;

    /**
     * Gives back a Json File with all Reservations
     * @param model
     * @return
     */
    @CrossOrigin
    @GetMapping("/Alexa")
    public List<Reservation>  getAll(Model model){
        List<Reservation> reservations =   reservationService.findAll();
        return reservations;
    }




}
