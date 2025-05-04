package com.example.airbnb_ys.model;

import jakarta.persistence.*;

@Entity
public class RoomPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTO_ID")
    private Long photoId;

    @OneToOne
    @JoinColumn(name = "ROON_ID")
    private Room roomId;

    private Enum roomPhotoCategory;

    private String roomPhotoUrl;
}
