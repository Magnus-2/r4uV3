package com.r4u.Alexa.services;

import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.repositories.ReservationRepository;
import com.r4u.Reservation.services.ReservationService;

import java.util.Collection;

public class TaskList {

    private Reservation reservation;
    private Collection<Reservation> reservationtask;
    public TaskList(Reservation reservation) {this.reservation =reservation;}



    public Collection<Reservation> getReservation() {return reservationtask;}



    public void setReservation(){
        ReservationService reservationManager = null;
        reservationtask = reservationManager.findAll();
    }

}
