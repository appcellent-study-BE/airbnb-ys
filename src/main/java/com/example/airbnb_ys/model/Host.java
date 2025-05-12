package com.example.airbnb_ys.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
public class Host {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HOST_ID")
    private int hostId;

    @OneToOne
    @JoinColumn(name = "USER_ID")
    private Member userId;

    private LocalDate hostDate;

    private boolean isEmail;

    private boolean isPhoneNum;

    public Host(Member userId, LocalDate hostDate, boolean isEmail, boolean isPhoneNum){
        this.userId = userId;
        this.hostDate = hostDate;
        this.isEmail = isEmail;
        this.isPhoneNum = isPhoneNum;
    }
}
