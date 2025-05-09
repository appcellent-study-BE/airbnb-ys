package com.example.airbnb_ys.model.Room;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class RoomPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PHOTO_ID")
    private int photoId;

    @OneToOne
    @JoinColumn(name = "ROON_ID")
    private Room roomId;

    @ElementCollection
    private List<String> roomPhotoUrl;
}
