package com.r4u.Restaurant.repositories;

import com.r4u.Restaurant.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
/**
 * Implements the ground functions of a Restaurant which
 * will be specialized by the Class Restaurantervice
 */
@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {


}
