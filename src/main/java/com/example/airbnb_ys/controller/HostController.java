package com.example.airbnb_ys.controller;

import com.example.airbnb_ys.dto.Response;
import com.example.airbnb_ys.dto.RoomRequestDto;
import com.example.airbnb_ys.model.Member;
import com.example.airbnb_ys.service.HostService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HostController {
    private final HostService hostService;

    public HostController(HostService hostService){
        this.hostService = hostService;
    }

    @PostMapping("/host/homes")
    public Response<Object> newHost(@RequestBody int userId){
        hostService.newHost(userId);
        return Response.success("호스트 등록 성공", null);
    }

    @PostMapping("/become-a-host")
    public Response<Object> becomeHost(@RequestBody Member userId, @RequestBody RoomRequestDto roomRequestDto){
        hostService.becomeHost(userId, roomRequestDto);
        return Response.success("숙소 등록 성공", null);
    }
}
