package com.r4u.Reservation.repositories;

import com.r4u.Reservation.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Implements the ground functions of a Reservation which
 * will be specialized by the Class ReservationService
 */
@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
