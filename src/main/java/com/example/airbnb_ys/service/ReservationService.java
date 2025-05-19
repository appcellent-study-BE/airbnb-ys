package com.example.airbnb_ys.service;

import com.example.airbnb_ys.dto.RoomBookingRequestDto;
import com.example.airbnb_ys.exception.CustomException;
import com.example.airbnb_ys.exception.ErrorCode;
import com.example.airbnb_ys.model.Enum.ReserveStatus;
import com.example.airbnb_ys.model.Member;
import com.example.airbnb_ys.model.Reservation;
import com.example.airbnb_ys.model.Room.Room;
import com.example.airbnb_ys.repository.MemberRepository;
import com.example.airbnb_ys.repository.ReservationRepository;
import com.example.airbnb_ys.repository.RoomRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static com.example.airbnb_ys.exception.ErrorCode.ID_NOT_FOUND;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final MemberRepository memberRepository;
    private final RoomRepository roomRepository;

    public ReservationService(ReservationRepository reservationRepository, MemberRepository memberRepository, RoomRepository roomRepository) {
        this.reservationRepository = reservationRepository;
        this.memberRepository = memberRepository;
        this.roomRepository = roomRepository;
    }

    // 숙소 예약하기
    @Transactional
    public int roomBooking(int roomId_input, RoomBookingRequestDto roomBookingRequestDto){
        // Todo : 날짜 겹치게 예약 못하도록
        int userId_input = roomBookingRequestDto.getUserId();
        Member userId = memberRepository.findById(userId_input).
                orElseThrow(() -> new CustomException(ErrorCode.ID_NOT_FOUND));

        // int roomId_input = roomBookingRequestDto.getRoomId();
        Room roomId = roomRepository.findById(roomId_input)
                .orElseThrow(() -> new CustomException(ErrorCode.ROOM_NOT_FOUND));

        LocalDateTime checkInDateTime = roomBookingRequestDto.getCheckInDate();
        LocalDate checkInDate = checkInDateTime.toLocalDate();

        Reservation reservation = new Reservation(
                userId, roomId,
                checkInDateTime,
                roomBookingRequestDto.getCheckOutDate(),
                ReserveStatus.CONFIRMED,
                roomBookingRequestDto.getAdults(),
                roomBookingRequestDto.getChildren(),
                roomBookingRequestDto.getInfants(),
                roomBookingRequestDto.getPets()
        ); reservationRepository.save(reservation);

        int reservationId = reservationRepository.
                findByUserIdAndRoomIdAndCheckInDate(userId, roomId, checkInDateTime)
                .getReservationId();
        return reservationId;
    }

    // 숙소 예약 취소하기
//    public void roomCanceling(@RequestParam int reservationId){
//
//    }
}
