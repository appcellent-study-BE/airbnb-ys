package com.example.airbnb_ys.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
public class Rooms {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private Long roomId;

    @ManyToOne
    @JoinColumn(name = "HOST_ID")
    private Hosts hostId;

    private String roomName;

    private String roomDscrptn;

    private String roomAddress;

    private String roomLocation;

    // Fixme 이런거 리스트/배열같은 걸로 묶으면 더 나으려나?
    private int roomAdultMax;

    private int roomChildrenMax;

    private int roomPetMax;

    private int bedroomNum;

    private int bathroomNum;

    private float roomPrice;

    private LocalTime checkInTime;

    private LocalTime checkOutTime;
}
