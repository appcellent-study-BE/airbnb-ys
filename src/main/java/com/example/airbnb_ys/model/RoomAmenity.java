package com.example.airbnb_ys.model;

import jakarta.persistence.*;

@Entity
public class RoomAmenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_AMENITY_ID")
    private Long roomAmenityId;

    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "AMENITY_ID")
    private Amenity amenityId;

    private boolean isAmenity;
}
