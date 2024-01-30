package com.example.hospital.service;

import com.example.hospital.dto.RoomRequestDto;
import com.example.hospital.dto.RoomResponseDto;

public interface RoomService {
    RoomResponseDto createRoom(RoomRequestDto requestDto);

    RoomResponseDto getRoom(String externalId);
}
