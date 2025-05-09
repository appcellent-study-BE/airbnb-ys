package com.example.airbnb_ys.model;

import com.example.airbnb_ys.model.Enum.Gender;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Getter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;

    @Column(length = 20)
    private String userName;

    @Column(length = 20)
    private String userLoginId;

    @Column(length = 20)
    private String userPassword;

    @Column(length = 20)
    private String userProfileUrl;

    private String userEmail; // VARCHAR(225)

    @Column(length = 13) // VARCHAR(13) 대응
    private String userPhoneNum;

    private LocalDate userDOB;

    private boolean isHost;

    private LocalDate registerDate;

    @Enumerated(EnumType.STRING)
    private Gender userGender;

    private boolean isCertificate;
}
