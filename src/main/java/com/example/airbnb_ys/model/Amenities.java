package com.example.airbnb_ys.model;

import jakarta.persistence.*;

@Entity
public class Amenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AMENITY_ID")
    private Long amenityId;

    private Enum amenityCategory;

    private String amenity;
}
