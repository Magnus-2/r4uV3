package com.kindsonthegenius.r4u.Reservation.repositories;

import com.kindsonthegenius.r4u.Reservation.models.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Integer> {

}
