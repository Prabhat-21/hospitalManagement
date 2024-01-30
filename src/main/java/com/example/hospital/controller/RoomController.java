package com.example.hospital.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hospital.dto.RoomRequestDto;
import com.example.hospital.dto.RoomResponseDto;
import com.example.hospital.service.RoomService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api/rooms")
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class RoomController {
    private final RoomService roomService;

    @PostMapping ("")
    public ResponseEntity<RoomResponseDto> createRoom(@RequestBody final RoomRequestDto request) {
        return new ResponseEntity<>(roomService.createRoom(request), HttpStatus.CREATED);
    }

    @GetMapping ("/{externalId}")
    public ResponseEntity<RoomResponseDto> getRoom(@PathVariable ("externalId") final String externalId) {
        return new ResponseEntity<>(roomService.getRoom(externalId), HttpStatus.OK);
    }
}
