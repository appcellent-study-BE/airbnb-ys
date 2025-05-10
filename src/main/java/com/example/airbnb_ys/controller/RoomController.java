package com.example.airbnb_ys.controller;

import com.example.airbnb_ys.dto.Response;
import com.example.airbnb_ys.dto.RoomInfoResponseDto;
import com.example.airbnb_ys.service.RoomService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rooms")
public class RoomController {
    private final RoomService roomService;

    public RoomController(RoomService roomService){
        this.roomService = roomService;
    }

    @GetMapping("/{roomId}")
    public Response<RoomInfoResponseDto> getRoomInfo(@RequestBody int roomId){
        return Response.success("방 상세정보 불러오기 성공", roomService.getRoomInfo(roomId));
    }
}
