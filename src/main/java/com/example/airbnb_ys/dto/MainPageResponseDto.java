package com.example.airbnb_ys.dto;

import java.math.BigDecimal;

public class MainPageResponseDto {
    private int roomId;
    private String roomName;
    private String roomAddress;
    private BigDecimal roomPrice;
    private float averageRating;
    private int reviewCount;

    public MainPageResponseDto(Room room){
        this.roomId = room.getRoomId();
        this.roomName = room.getRoomName();
        this.roomAddress = room.getRoomAddress();
        this.roomPrice = room.getRoomPrice();
        this.averageRating = 4.5f; // Todo : 별점 평균 계산 or 맞게 반환
        this.reviewCount = room.getReviews().size();
    } // Todo 서비스단으로 넘길지 더 찾아보기
}
