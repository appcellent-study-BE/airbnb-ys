package com.example.airbnb_ys.service;

import com.example.airbnb_ys.dto.MainPageResponseDto;
import com.example.airbnb_ys.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MainPageService {

    private final RoomRepository roomRepository;

    public MainPageService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    //    public List<Room> getAllRooms(){
//        return roomRepository.findAll();
//    }
    public List<MainPageResponseDto> getAllRooms(){
        return roomRepository.findAll().stream() // stream() : 컬렉션 처리 기능을 함수형 스타일로 제공
                .map(MainPageResponseDto::new) // Room -> DTO 로 변환
                .collect(Collectors.toList());
    }

}
