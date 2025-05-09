package com.example.airbnb_ys.repository;

import com.example.airbnb_ys.model.Room.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
