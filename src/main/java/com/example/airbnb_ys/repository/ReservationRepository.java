package com.example.airbnb_ys.repository;

import com.example.airbnb_ys.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
}
