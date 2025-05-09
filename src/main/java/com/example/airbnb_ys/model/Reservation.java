package com.example.airbnb_ys.model;

import com.example.airbnb_ys.model.Enum.ReserveStatus;
import com.example.airbnb_ys.model.Room.Room;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERBATION_ID")
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member userId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room roomId;

    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    @Enumerated(EnumType.STRING)
    private ReserveStatus status;

    private int adults;

    private int children;

    private int infants;

    private int pets;
}
