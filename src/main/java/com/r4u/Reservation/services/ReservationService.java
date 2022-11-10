package com.r4u.Reservation.services;

import com.r4u.Reservation.models.Reservation;
import com.r4u.Reservation.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * The Reservation Service specialise the functions
 * which you can use to get Data for example
 */
@Service
public class ReservationService {
	/**
	 * Tells Spring to connect with the
	 * class ReservationRepository
	 */
	@Autowired
	private ReservationRepository reservationRepository;

	/**
	 * Gives you all Reservations back
	 * @return
	 */
	public List<Reservation> findAll(){
		return reservationRepository.findAll();
	}


	/**
	 * Gives you a Reservation back with the accordingly Id
	 * @param id
	 * @return
	 */
	public Reservation findById(int id) {
		return reservationRepository.findById(id).orElse(null);
	}

	/**
	 * Delets a Reservation based on the Id
	 * @param id
	 */
	public void delete(int id) {
		reservationRepository.deleteById(id);
	}

	/**
	 * Saves a new Reservation
	 * As well as an edited Reservation
	 * @param reservation
	 */
	public void save(Reservation reservation) {
		reservationRepository.save(reservation);
	}



}
