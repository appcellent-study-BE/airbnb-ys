package com.example.airbnb_ys.controller;

import com.example.airbnb_ys.dto.Response;
import com.example.airbnb_ys.dto.ReviewRequestDto;
import com.example.airbnb_ys.service.ReviewService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @PostMapping("/write-review")
    public Response<Object> writeReview(@RequestBody ReviewRequestDto reviewRequestDto){
        reviewService.writeReview(reviewRequestDto);
        return Response.success("리뷰 작성 성공", null);
    }
}
