package com.project.contoller;

import com.project.entity.Restaurant;
import com.project.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello()
    {
        return "welcome in our code";
    }


    @GetMapping("/restaurant/{id}")
    public Restaurant getById(@PathVariable("id") int id)
    {
        Restaurant byId = restaurantService.getById(id);
        System.out.println(byId);
        return byId;
    }

    @GetMapping("/restaurant/view")
    public List<Restaurant> viewRestaurant()
    {
        return restaurantService.getAllRestaurant();
    }

    @PostMapping("/admin/restaurant/add")
    public ResponseEntity<Object> addRestaurant(@RequestBody Restaurant restaurant)
    {
        return restaurantService.addRestaurant(restaurant);
    }

    @PostMapping("/admin/restaurant/update/{id}")
    public ResponseEntity<Object> UpdateRestaurant(@RequestBody Restaurant restaurant,
                                           @PathVariable("id") int id)
    {
        return restaurantService.updateRestaurant(restaurant,id);
    }

    @DeleteMapping("/admin/restaurant/delete/{id}")
    public ResponseEntity<Object> deleteById(@PathVariable("id") int id)
    {
        return restaurantService.deleteById(id);
    }
}

