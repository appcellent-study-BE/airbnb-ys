package com.example.airbnb_ys.dto;

import com.example.airbnb_ys.model.Room.Room;

import java.math.BigDecimal;

public class MainPageResponseDto {
    private int roomId;
    private String roomName;
    private String roomAddress;
    private BigDecimal roomPrice;
    private float averageRating;
    private int reviewCount;

    public MainPageResponseDto(Room room, float averageRating, int reviewCount){
        this.roomId = room.getRoomId();
        this.roomName = room.getRoomName();
        this.roomAddress = room.getRoomAddress();
        this.roomPrice = room.getRoomPrice();
        this.averageRating = averageRating;
        this.reviewCount = reviewCount;
    }
}
