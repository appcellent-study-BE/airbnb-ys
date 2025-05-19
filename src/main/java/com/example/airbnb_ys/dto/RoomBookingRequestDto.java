package com.example.airbnb_ys.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RoomBookingRequestDto {
    private int roomId;
    private int userId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkInDate;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime checkOutDate;

    private int adults;
    private int children;
    private int infants;
    private int pets;
    // private BigDecimal roomPrice; // Fixme : 이거 필요해 ...?
}
