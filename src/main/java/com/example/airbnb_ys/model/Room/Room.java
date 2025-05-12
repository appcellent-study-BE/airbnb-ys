package com.example.airbnb_ys.model.Room;

import com.example.airbnb_ys.model.Host;
import com.example.airbnb_ys.model.Review;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.w3c.dom.Text;

import java.math.BigDecimal;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ROOM_ID")
    private int roomId;

    @ManyToOne
    @JoinColumn(name = "HOST_ID")
    private Host hostId;

    @Column(length = 50)
    private String roomName;

    @Column(columnDefinition = "TEXT")
    private String roomDescription;

    @Column(length = 150)
    private String roomAddress;

    @Column(length = 500)
    private String roomLocation;

    private int roomAdultMax;
    private int roomChildrenMax;
    private int roomPetMax;

    private int bedroomNum;
    private int bathroomNum;

    @Column(precision = 10, scale = 2)
    private BigDecimal roomPrice;

    private LocalTime checkInTime;
    private LocalTime checkOutTime;

    @OneToMany(mappedBy = "roomId", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();
    // Review 클래스의 roomId 필드가 주인이라는 의미
    // cascade 는 방을 삭제하면 그에 달린 리뷰도 함께 삭제됨

    public Room(Host hostId, String roomName, String roomDescription, String roomAddress, String roomLocation,
                int roomAdultMax, int roomChildrenMax, int roomPetMax, int bedroomNum,
                int bathroomNum, BigDecimal roomPrice, LocalTime checkInTime, LocalTime checkOutTime){
        this.hostId = hostId;
        this.roomName = roomName;
        this.roomDescription = roomDescription;
        this.roomAddress = roomAddress;
        this.roomLocation = roomLocation;
        this.roomAdultMax = roomAdultMax;
        this.roomChildrenMax = roomChildrenMax;
        this.roomPetMax = roomPetMax;
        this.bedroomNum = bedroomNum;
        this.bathroomNum = bathroomNum;
        this.roomPrice = roomPrice;
        this.checkInTime = checkInTime;
        this.checkOutTime = checkOutTime;
    }
}
