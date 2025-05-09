package com.example.airbnb_ys.dto;

public class ReviewRequestDto {
    private String review;
    private float rating;
    private float ratingClean;
    private float ratingAccuracy;
    private float ratingCheckIn;
    private float ratingCommunication;
    private float ratingLocation;
    private float ratingPrice;

    // 예약 번호도 받아야 하고 + 숙소 사용 날짜 
    // 리뷰 등록 날짜도 받아야 함
}
