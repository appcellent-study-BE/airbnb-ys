package com.example.airbnb_ys.dto;

import com.example.airbnb_ys.model.Member;
import com.example.airbnb_ys.model.Review;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ReviewResponseDto {
//    private Long reivewId;
    private Member userId;
    private String userName;
    private LocalDate registerDate; // 가입 기간으로 계산하도록
    private String review;
    private LocalDateTime reviewDate; // 시간 달라지면 ZonedDateTime 사용
    private int averageRating;

    public ReviewResponseDto(Review review){
        this.userId = review.getUserId();
        this.userName = review.getUserId().getUserName();
        this.registerDate = review.getUserId().getRegisterDate();
        this.review = review.getReview();
        this.reviewDate = review.getReviewDate();
    }
}
