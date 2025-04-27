package com.example.airbnb_ys.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "REVIEW_ID")
    private Long reviewId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Rooms roomId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Members userId;

    private float averageRating;

    private String review;

    private LocalDateTime reviewDate;

    private float ratingClean;
    private float ratingAccuracy;
    private float ratingCheckIn;
    private float ratingConversation;
    private float ratingLocation;
    private float ratingPrice;
}
