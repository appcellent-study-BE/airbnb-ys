package com.example.airbnb_ys.dto;

import com.example.airbnb_ys.model.Room.Room;

import java.util.List;
import java.util.stream.Collectors;

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

    public RoomInfoResponseDto(Room room){
        this.roomName = room.getRoomName();
        this.roomMax = room.getRoomAdultMax() + room.getRoomChildrenMax();
        this.bedroomNum = room.getBedroomNum();
        this.bathroomNum = room.getBathroomNum();
        this.roomDscrptn = room.getRoomDscrptn();
        this.roomAddress = room.getRoomAddress();
        this.roomLocation = room.getRoomLocation();
        this.ratings = new RatingDto(room.getReviews());
        this.reviews = room.getReviews().stream()
                .map(ReviewResponseDto::new)
                .collect(Collectors.toList());
    }
}
