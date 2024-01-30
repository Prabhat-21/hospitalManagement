package com.example.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.dao.HospitalRepository;
import com.example.hospital.dao.RoomRepository;
import com.example.hospital.dto.RoomRequestDto;
import com.example.hospital.dto.RoomResponseDto;
import com.example.hospital.entities.Room;
import com.example.hospital.error.Error;
import com.example.hospital.service.RoomService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class RoomServiceImpl implements RoomService {
    private final RoomRepository roomRepository;

    private final HospitalRepository hospitalRepository;

    @Override
    public RoomResponseDto createRoom(RoomRequestDto requestDto) {
        final Room room = new Room(requestDto);
        hospitalRepository.findByExternalId(room.getHospitalId()).orElseThrow(Error.HOSPITAL_NOT_FOUND.getBuilder()::build);
        roomRepository.save(room);
        return new RoomResponseDto(room);
    }

    @Override
    public RoomResponseDto getRoom(String externalId) {
        final Room room = roomRepository.findByExternalId(externalId).orElseThrow(Error.ROOM_NOT_FOUND.getBuilder()::build);
        return new RoomResponseDto(room);
    }
}