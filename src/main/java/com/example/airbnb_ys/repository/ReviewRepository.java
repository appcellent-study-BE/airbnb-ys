package com.example.airbnb_ys.repository;

import com.example.airbnb_ys.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Integer> {
    List<Review> findByRoomId(int roomId);
}
