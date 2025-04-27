package com.example.airbnb_ys.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class RoomDates {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_DATE_ID")
    private Long roomDateId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Rooms roomId;

    private LocalDate bookingDate;

    private boolean isBooked;
}
