package com.example.airbnb_ys.service;

import com.example.airbnb_ys.dto.RoomRequestDto;
import com.example.airbnb_ys.model.Host;
import com.example.airbnb_ys.model.Member;
import com.example.airbnb_ys.model.Room.Room;
import com.example.airbnb_ys.repository.HostRepository;
import com.example.airbnb_ys.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;

@Service
public class HostService {
    private final HostRepository hostRepository;
    private final MemberRepository memberRepository;

    public HostService(HostRepository hostRepository, MemberRepository memberRepository){
        this.hostRepository = hostRepository;
        this.memberRepository = memberRepository;
    }

    // 호스트 등록하기
    public void newHost(@RequestBody int userId){
        // Todo 1. Member 태이블에서 isHost -> true 로 변경

        // 2-1. Member 테이블에서 이메일, 전화번호 있는지 가져오기
        Member member = memberRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("아이디 없음"));
        boolean isEmail = member.getUserEmail() == null || member.getUserEmail().isEmpty();
        boolean isPhoneNum = member.getUserPhoneNum() == null || member.getUserPhoneNum().isEmpty();

        // 2-2. Host 테이블 객체 생성
        Host host = new Host(
                member,
                LocalDate.now(),
                isEmail,
                isPhoneNum
        );
        hostRepository.save(host);

        // (3.) Host 테이블의 이메일 인증, 전화번호 인증은 Member 테이블과 연동되도록
    }

    // 숙소 등록하기
    public void becomeHost(@RequestBody Member userId, @RequestBody RoomRequestDto roomRequestDto){
        // userId 로 hostId 만들기
        Host hostId = hostRepository.findByUserId(userId);

        // 숙소 정보 입력받아서 숙소 등록하기
        Room room = new Room(
                hostId,
                roomRequestDto.getRoomName(),
                roomRequestDto.getRoomDescription(),
                roomRequestDto.getRoomAddress(),
                roomRequestDto.getRoomLocation(),
                roomRequestDto.getRoomAdultMax(),
                roomRequestDto.getRoomChildrenMax(),
                roomRequestDto.getRoomPetMax(),
                roomRequestDto.getBedroomNum(),
                roomRequestDto.getBathroomNum(),
                roomRequestDto.getRoomPrice(),
                roomRequestDto.getCheckInTime(),
                roomRequestDto.getCheckOutTime()
        );
    }
}
