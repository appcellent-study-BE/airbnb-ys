package com.example.airbnb_ys.controller;

import com.example.airbnb_ys.dto.Response;
import com.example.airbnb_ys.dto.RoomBookingRequestDto;
import com.example.airbnb_ys.model.Room.Room;
import com.example.airbnb_ys.service.ReservationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService){
        this.reservationService = reservationService;
    }

    @PostMapping("/stays/{roomId}")
    public Response<Integer> roomBooking(@PathVariable("roomId") int roomId,
                                         @RequestBody RoomBookingRequestDto roomBookingRequestDto){
        int reservationId = reservationService.roomBooking(roomId, roomBookingRequestDto);
        return Response.success("숙소 예약 성공", reservationId);
    }

//    @DeleteMapping("/{reservationId}")
//    public Response<Object> roomCanceling(@PathVariable int reservationId){
//        reservationService.roomCanceling(reservationId);
//        return Response.success("숙소 예약 취소 성공", null);
//    }
}
