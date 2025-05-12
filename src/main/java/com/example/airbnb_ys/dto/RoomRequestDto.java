package com.example.airbnb_ys.dto;

import lombok.Getter;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.time.LocalTime;

@Getter
public class RoomRequestDto {
    // private int hostId; 이건 userId 이용해서 받아와
    private String roomName;
    private String roomDescription;
    private String roomAddress;
    private String roomLocation;
    private int roomAdultMax;
    private int roomChildrenMax;
    private int roomPetMax;
    private int bedroomNum;
    private int bathroomNum;
    private BigDecimal roomPrice;
    private LocalTime checkInTime;
    private LocalTime checkOutTime;
}
