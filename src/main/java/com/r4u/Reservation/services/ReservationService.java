package com.r4u.Reservation.services;

import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
	
	@Autowired
	private ReservationRepository reservationRepository;
	
	//Get All Reservations
	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}


	//Get reservation By Id
	public Reservation findById(int id) {
		return reservationRepository.findById(id).orElse(null);
	}	
	
	//Delete reservation
	public void delete(int id) {
		reservationRepository.deleteById(id);
	}
	
	//Update reservation
	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}



}
