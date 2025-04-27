package com.example.airbnb_ys.model;

import jakarta.persistence.*;

@Entity
public class RoomAmenities {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_AMENITY_ID")
    private Long roomAmenityId;

    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Rooms roomId;

    @ManyToOne
    @JoinColumn(name = "AMENITY_ID")
    private Amenities amenityId;

    private boolean isAmenity;
}
