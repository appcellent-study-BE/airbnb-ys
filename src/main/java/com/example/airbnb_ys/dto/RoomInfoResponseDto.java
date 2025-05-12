package com.example.airbnb_ys.dto;

import com.example.airbnb_ys.model.Room.Room;

import java.util.List;

public class RoomInfoResponseDto {
    private String roomName;
    private int roomMax;
    private int bedroomNum;
    private int bathroomNum;
    private String roomDscrptn;
    private String roomAddress;
    private String roomLocation;
    private RatingDto ratings;
    private List<ReviewResponseDto> reviews;

    public RoomInfoResponseDto(Room room, RatingDto ratings, List<ReviewResponseDto> reviews){
        this.roomName = room.getRoomName();
        this.roomMax = room.getRoomAdultMax() + room.getRoomChildrenMax();
        this.bedroomNum = room.getBedroomNum();
        this.bathroomNum = room.getBathroomNum();
        this.roomDscrptn = room.getRoomDescription();
        this.roomAddress = room.getRoomAddress();
        this.roomLocation = room.getRoomLocation();
        this.ratings = ratings;
        this.reviews = reviews;
    }
}
