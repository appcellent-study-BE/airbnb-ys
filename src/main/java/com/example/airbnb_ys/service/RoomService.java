package com.example.airbnb_ys.service;

import com.example.airbnb_ys.dto.RatingDto;
import com.example.airbnb_ys.dto.ReviewResponseDto;
import com.example.airbnb_ys.dto.RoomInfoResponseDto;
import com.example.airbnb_ys.model.Review;
import com.example.airbnb_ys.model.Room.Room;
import com.example.airbnb_ys.repository.ReviewRepository;
import com.example.airbnb_ys.repository.RoomRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final ReviewRepository reviewRepository;

    public RoomService(RoomRepository roomRepository, ReviewRepository reviewRepository) {
        this.roomRepository = roomRepository;
        this.reviewRepository = reviewRepository;
    }

    public RoomInfoResponseDto getRoomInfo(@RequestBody int roomId){
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("방 존재 X"));

        // 별점 (평균) 계산하기
        List<Review> allReviews = reviewRepository.findByRoomId(room).stream().toList();
        RatingDto ratings = calRatings(allReviews);

        // 리뷰 받아오기
        // Todo : 현재 페이지 방에 해당하는 리뷰만 봐야함 (이미 그렇게 되어있는 건가?)
        List<ReviewResponseDto> reviews = room.getReviews().stream()
                .map(ReviewResponseDto::new)
                .collect(Collectors.toList());

        return new RoomInfoResponseDto(room, ratings, reviews);
    }

    public RatingDto calRatings(List<Review> allReviews){
        int size = allReviews.size();

        float rating = 0;
        float ratingClean = 0;
        float ratingAccuracy = 0;
        float ratingCheckin = 0;
        float ratingCommunication = 0;
        float ratingLocation = 0;
        float ratingPrice = 0;

        // Todo : 리뷰 없는 경우 처리해야 함
        if (size == 0)
            return new RatingDto(0, 0, 0, 0, 0, 0, 0);

        for (Review review : allReviews) {
            rating += review.getRating();
            ratingClean += review.getRatingClean();
            ratingAccuracy += review.getRatingAccuracy();
            ratingCheckin += review.getRatingCheckIn();
            ratingCommunication += review.getRatingCommunication();
            ratingLocation += review.getRatingLocation();
            ratingPrice += review.getRatingPrice();
        }

        return new RatingDto(
            round1(rating / size),
            round1(ratingClean / size),
            round1(ratingAccuracy / size),
            round1(ratingCheckin / size),
            round1(ratingCommunication / size),
            round1(ratingLocation / size),
            round1(ratingPrice / size)
        );
    }

    private float round1(float value) {
        return Math.round(value * 10f) / 10f; // 소수점 첫째 자리까지 반올림
    }
}
