package com.r4u.Restaurant.services;


import com.r4u.Reservation.models.Reservation;
import com.r4u.Restaurant.models.Restaurant;
import com.r4u.Restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepository restaurantRepository;

    //Get All Users
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    //Get User By Id
    public Restaurant findById(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }


    //Delete User
    public void delete(int id) {
        restaurantRepository.deleteById(id);
    }

    //Update User
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

}
