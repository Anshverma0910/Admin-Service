package com.project.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int restaurantId;
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantCity;
    private String restaurantPasscode;
    private String restaurantPhoneNo;
    private String restaurantEmail;
    private String restaurantCreated;
    @OneToMany(mappedBy = "restaurantId",cascade = CascadeType.ALL)
    private List<Category> categories;
    private int restaurantRating;

}
