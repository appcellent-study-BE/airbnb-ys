package com.example.airbnb_ys.controller;

import com.example.airbnb_ys.dto.MainPageResponseDto;
import com.example.airbnb_ys.service.MainPageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping()
public class MainPageController {
    private final MainPageService mainPageService;

    public MainPageController(MainPageService mainPageService){
        this.mainPageService = mainPageService;
    }

//    @GetMapping("/")
//    public List<Room> getAllRooms(){
//        return mainPageService.getAllRooms();
//    }

    @GetMapping("/")
    public List<MainPageResponseDto> getAllRooms(){
        return mainPageService.getAllRooms();
    }
}
