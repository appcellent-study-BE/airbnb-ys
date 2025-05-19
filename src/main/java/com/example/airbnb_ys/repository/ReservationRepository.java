package com.example.airbnb_ys.repository;

import com.example.airbnb_ys.model.Member;
import com.example.airbnb_ys.model.Reservation;
import com.example.airbnb_ys.model.Room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ReservationRepository extends JpaRepository<Reservation, Integer> {
    Reservation findByUserIdAndRoomIdAndCheckInDate(Member userId, Room roomId, LocalDateTime checkInDate);
}
