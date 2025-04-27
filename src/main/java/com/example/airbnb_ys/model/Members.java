package com.example.airbnb_ys.model;

import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
public class Members {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Long userId;

    private String userName;

    private String userLoginId;

    private String userPassword;

    //Todo userProfileImg

    private String userEmail;

    //Todo userPhoneNum

    private LocalDate userDOB;

    // Todo default false
    private boolean isHost;

    private LocalDate registerDate;

    private Enum userGender;

    // Todo default false
    private boolean isCertificate;
}
