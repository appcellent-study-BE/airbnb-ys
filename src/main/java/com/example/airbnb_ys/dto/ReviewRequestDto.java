package com.example.airbnb_ys.dto;

import lombok.Getter;

@Getter
public class ReviewRequestDto {
    private int reservationId;
    private String review;
    private float rating;
    private float ratingClean;
    private float ratingAccuracy;
    private float ratingCheckIn;
    private float ratingCommunication;
    private float ratingLocation;
    private float ratingPrice;

    // 숙소 사용 날짜
}
