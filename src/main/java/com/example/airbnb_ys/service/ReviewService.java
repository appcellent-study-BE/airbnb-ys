package com.example.airbnb_ys.service;

import com.example.airbnb_ys.dto.ReviewRequestDto;
import com.example.airbnb_ys.model.Member;
import com.example.airbnb_ys.model.Reservation;
import com.example.airbnb_ys.model.Review;
import com.example.airbnb_ys.model.Room.Room;
import com.example.airbnb_ys.repository.ReservationRepository;
import com.example.airbnb_ys.repository.ReviewRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDateTime;

@Service
public class ReviewService {
    private final ReservationRepository reservationRepository;
    private final ReviewRepository reviewRepository;

    public ReviewService(ReservationRepository reservationRepository, ReviewRepository reviewRepository) {
        this.reservationRepository = reservationRepository;
        this.reviewRepository = reviewRepository;
    }

    public void writeReview(@RequestBody ReviewRequestDto reviewRequestDto){
        System.out.println(reviewRequestDto.getReservationId());
        Reservation reservation = reservationRepository.findById(reviewRequestDto.getReservationId())
                .orElseThrow(() -> new IllegalArgumentException("해당 예약이 존재하지 않습니다."));

        Room roomId = reservation.getRoomId();
        Member userId = reservation.getUserId();

        Review review = new Review(
                roomId,
                userId,
                reviewRequestDto.getReview(),
                LocalDateTime.now(),
                reviewRequestDto.getRating(),
                reviewRequestDto.getRatingClean(),
                reviewRequestDto.getRatingAccuracy(),
                reviewRequestDto.getRatingCheckIn(),
                reviewRequestDto.getRatingCommunication(),
                reviewRequestDto.getRatingLocation(),
                reviewRequestDto.getRatingPrice()
        );
        reviewRepository.save(review);
    }
}
