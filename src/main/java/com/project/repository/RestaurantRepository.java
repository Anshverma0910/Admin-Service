package com.project.repository;

import com.project.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant,Integer> {
//    public Restaurant getById(int id);

}
