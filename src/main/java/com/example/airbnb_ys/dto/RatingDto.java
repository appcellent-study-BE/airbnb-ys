package com.example.airbnb_ys.dto;

import com.example.airbnb_ys.model.Review;

import java.util.List;

public class RatingDto {
    private float averageRating;
    private float ratingClean;
    private float ratingAccuracy;
    private float ratingCheckin;
    private float ratingCommunication;
    private float ratingLocation;
    private float ratingPrice;

    public RatingDto(List<Review> reviews){
        // Todo : 현재 페이지 방에 해당하는 리뷰만 봐야함 (이미 그렇게 되어있는 건가?)

        // Todo : 리뷰 없는 경우 처리해야 함
        int size = reviews.size();
        for (Review review : reviews) {
            this.averageRating += review.getRating();
            this.ratingClean += review.getRatingClean();
            this.ratingAccuracy += review.getRatingAccuracy();
            this.ratingCheckin += review.getRatingCheckIn();
            this.ratingCommunication += review.getRatingCommunication();
            this.ratingLocation += review.getRatingLocation();
            this.ratingPrice += review.getRatingPrice();
        }

        this.averageRating = round1(averageRating / size);
        this.ratingClean = round1(ratingClean / size);
        this.ratingAccuracy = round1(ratingAccuracy / size);
        this.ratingCheckin = round1(ratingCheckin / size);
        this.ratingCommunication = round1(ratingCommunication / size);
        this.ratingLocation = round1(ratingLocation / size);
        this.ratingPrice = round1(ratingPrice / size);
    }
    private float round1(float value) {
        return Math.round(value * 10f) / 10f; // 소수점 첫째 자리까지 반올림
    }
}
