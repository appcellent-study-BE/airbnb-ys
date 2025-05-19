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

    public List<MainPageResponseDto> getAllRooms() {
        return roomRepository.findAll().stream() // stream() : 컬렉션 처리 기능을 함수형 스타일로 제공
                .map(room -> { // Room -> DTO 로 변환
                    float averageRating = 4.5f; // Todo : 별점 평균 계산 or 맞게 반환
                    int reviewCount = room.getReviews().size();
                    return new MainPageResponseDto(room, averageRating, reviewCount);
                }).collect(Collectors.toList());
    }
}
