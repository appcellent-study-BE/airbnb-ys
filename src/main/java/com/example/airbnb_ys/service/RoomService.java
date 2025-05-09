package com.example.airbnb_ys.service;

import com.example.airbnb_ys.dto.RoomInfoResponseDto;
import com.example.airbnb_ys.model.Room.Room;
import com.example.airbnb_ys.repository.RoomRepository;
import org.springframework.stereotype.Service;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public RoomInfoResponseDto getRoomInfo(Long roomId){
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new IllegalArgumentException("방 존재 X"));
        // 이렇게 서비스단에서 뭐 안하고 디티오로 처리해도 되는 건가 ...
        return new RoomInfoResponseDto(room);
    }
}
