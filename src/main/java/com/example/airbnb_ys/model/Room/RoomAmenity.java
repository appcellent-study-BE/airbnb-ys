package com.example.airbnb_ys.model.Room;

import com.example.airbnb_ys.model.Amenity;
import jakarta.persistence.*;

@Entity
public class RoomAmenity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_AMENITY_ID")
    private int roomAmenityId;

    @OneToOne
    @JoinColumn(name = "ROOM_ID")
    private Room roomId;

    @ManyToOne
    @JoinColumn(name = "AMENITY_ID")
    private Amenity amenityId;

    private boolean isAmenity;
}
// Todo : 지금 M:1로 되어있는데 M:N으로 수정해야 함