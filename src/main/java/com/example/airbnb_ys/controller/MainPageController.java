package com.example.airbnb_ys.controller;

import com.example.airbnb_ys.dto.MainPageResponseDto;
import com.example.airbnb_ys.dto.Response;
import com.example.airbnb_ys.service.MainPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MainPageController {
    private final MainPageService mainPageService;

    public MainPageController(MainPageService mainPageService){
        this.mainPageService = mainPageService;
    }

    @GetMapping("/")
    public Response<List<MainPageResponseDto>> getAllRooms(){
        return Response.success("메인페이지 불러오기 성공.", mainPageService.getAllRooms());
    }
}
