package com.example.airbnb_ys.model;

import com.example.airbnb_ys.model.Enum.ReserveStatus;
import com.example.airbnb_ys.model.Room.Room;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESERVATION_ID")
    private int reservationId;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private Member userId;

    @ManyToOne
    @JoinColumn(name = "ROOM_ID")
    private Room roomId;

    private LocalDateTime checkInDate;
    private LocalDateTime checkOutDate;

    @Enumerated(EnumType.STRING)
    private ReserveStatus status;

    private int adults;

    private int children;

    private int infants;

    private int pets;

    public Reservation(Member userId, Room roomId, LocalDateTime checkInDate,
                       LocalDateTime checkOutDate, ReserveStatus status,
                       int adults, int children, int infants, int pets){
        this.userId = userId;
        this.roomId = roomId;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.status = status;
        this.adults = adults;
        this.children = children;
        this.infants = infants;
        this.pets = pets;
    }
}
