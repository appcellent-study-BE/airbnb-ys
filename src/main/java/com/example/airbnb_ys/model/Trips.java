package com.example.airbnb_ys.model;

import jakarta.persistence.*;

@Entity
public class Trips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIP_ID")
    private Long tripId;

    @OneToOne
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservationId;
}
