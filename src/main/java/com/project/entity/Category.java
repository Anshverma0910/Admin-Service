package com.project.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int categoryId;
    private String categoryName;
    private String categoryDscription;
    @OneToMany(mappedBy = "categoryId",cascade = CascadeType.ALL)
    private List<Product> products;
    private int restaurantId;

}
