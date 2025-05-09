package com.example.airbnb_ys.model;

import com.example.airbnb_ys.model.Room.Room;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private int reviewId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member userId;

    @Column(length = 500)
    private String review;

    private LocalDateTime reviewDate;

    private float rating;
    private float ratingClean;
    private float ratingAccuracy;
    private float ratingCheckIn;
    private float ratingCommunication;
    private float ratingLocation;
    private float ratingPrice;
}
