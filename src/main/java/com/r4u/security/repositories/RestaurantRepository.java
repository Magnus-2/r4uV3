package com.r4u.security.repositories;

import com.r4u.security.models.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Integer> {

    Restaurant findByUsername(String username);

}
