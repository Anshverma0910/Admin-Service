package com.project.service;

import com.project.entity.Restaurant;
import com.project.exception.restaurant.RestaurantNotFoundException;

import com.project.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantService {

    @Autowired
    private RestaurantRepository restaurantRepository;


    public List<Restaurant> getAllRestaurant()
    {
        return restaurantRepository.findAll();
    }

    public ResponseEntity<Object> addRestaurant(Restaurant restaurant)
    {
        restaurant.setRestaurantCreated(new Date().toString());
        try{
            restaurantRepository.save(restaurant);
            return new ResponseEntity<>("Restaurant added Succesfully",HttpStatus.ACCEPTED);
        }
        catch (RestaurantNotFoundException e)
        {
            throw new RestaurantNotFoundException();
        }
    }

    public Restaurant getById(int id)
    {
        Optional<Restaurant> byId = restaurantRepository.findById(id);
        if(byId.isEmpty()){
            throw new RestaurantNotFoundException();
        }
         Restaurant r1 = byId.get();
        return r1;
    }

    public ResponseEntity<Object> updateRestaurant(Restaurant restaurant, int id)
    {
        Restaurant newrestaurant = getById(id);
        System.out.println("inside update  "+newrestaurant);
        System.out.println();
        newrestaurant.setRestaurantCity(restaurant.getRestaurantCity());
        newrestaurant.setRestaurantEmail(restaurant.getRestaurantEmail());
        newrestaurant.setRestaurantName(restaurant.getRestaurantName());
        newrestaurant.setRestaurantPhoneNo(restaurant.getRestaurantPhoneNo());
        newrestaurant.setRestaurantAddress(restaurant.getRestaurantAddress());
        newrestaurant.setRestaurantPasscode(restaurant.getRestaurantPasscode());
        restaurantRepository.save(newrestaurant);
        return new ResponseEntity<>("Restaurant Updated Successfully",HttpStatus.ACCEPTED);
    }

    public ResponseEntity<Object> deleteById(@PathVariable("id") int id)
    {
        restaurantRepository.deleteById(id);
        return new ResponseEntity<>("Restaurant has been Deleted Successfully",HttpStatus.OK);

    }
}
