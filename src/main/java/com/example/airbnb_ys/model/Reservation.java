package com.example.airbnb_ys.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERBATION_ID")
    private Long reservationId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member userId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room roomId;

    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    private String status;

    private int adults;

    private int children;

    private int infants;

    private int pets;
}
