package com.project.serviceinterface;

import com.project.entity.Restaurant;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface RestaurantServiceInterface {

    public List<Restaurant> getAllRestaurant();

    public ResponseEntity<Object> addRestaurant(Restaurant restaurant);

    public Restaurant getById(int id);

    public ResponseEntity<Object> updateRestaurant(Restaurant restaurant, int id);

    public ResponseEntity<Object> deleteById(@PathVariable("id") int id);
}
