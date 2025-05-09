package com.example.airbnb_ys.model;

import com.example.airbnb_ys.model.Enum.AmenityCategories;
import jakarta.persistence.*;

@Entity
public class Amenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AMENITY_ID")
    private int amenityId;

    @Enumerated(EnumType.STRING)
    private AmenityCategories amenityCategory;

    private String amenity;
}
