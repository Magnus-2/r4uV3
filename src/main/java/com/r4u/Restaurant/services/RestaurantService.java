package com.r4u.Restaurant.services;



import com.r4u.Restaurant.models.Restaurant;
import com.r4u.Restaurant.repositories.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * The Restaurant Service specialise the functions
 * which you can use to get Data for example
 */
@Service
public class RestaurantService {


    @Autowired
    private RestaurantRepository restaurantRepository;

    //Get All
    public List<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    //public void update(Restaurant restaurant) {restaurantRepository.save(restaurant);}

    //Get  By Id
    public Restaurant findById(int id) {
        return restaurantRepository.findById(id).orElse(null);
    }

   // public Restaurant getById(Integer id) {return restaurantRepository.findById(id).orElse(null);}


    //Delete
    public void delete(int id) {
        restaurantRepository.deleteById(id);
    }

    //Update
    public void save(Restaurant restaurant) {
        restaurantRepository.save(restaurant);
    }

}
