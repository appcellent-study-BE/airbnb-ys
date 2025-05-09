package com.example.airbnb_ys.model.MyPage;

import com.example.airbnb_ys.model.Reservation;
import jakarta.persistence.*;

@Entity
public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TRIP_ID")
    private int tripId;

    @OneToOne
    @JoinColumn(name = "RESERVATION_ID")
    private Reservation reservationId;
}
