package com.example.airbnb_ys.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    ID_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 아이디입니다."),
    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "존재하지 않는 숙소입니다.");

    private final HttpStatus status;
    private final String message;
}