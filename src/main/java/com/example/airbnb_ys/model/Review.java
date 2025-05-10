package com.example.airbnb_ys.model;

import com.example.airbnb_ys.model.Room.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
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

    public Review(Room roomId, Member userId, String review, LocalDateTime reviewDate,
                  float rating, float ratingClean, float ratingAccuracy,float ratingCheckIn,
                  float ratingCommunication, float ratingLocation, float ratingPrice){
        this.roomId = roomId;
        this.userId = userId;
        this.review = review;
        this.reviewDate = reviewDate;
        this.rating = rating;
        this.ratingClean = ratingClean;
        this.ratingAccuracy = ratingAccuracy;
        this.ratingCheckIn = ratingCheckIn;
        this.ratingCommunication = ratingCommunication;
        this.ratingLocation = ratingLocation;
        this.ratingPrice = ratingPrice;
    }
}
