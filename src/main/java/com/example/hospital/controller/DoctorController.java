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
import com.example.hospital.dto.DoctorRequestDto;
import com.example.hospital.dto.DoctorResponseDto;
import com.example.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api/doctors")
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class DoctorController {
    private final DoctorService doctorService;

    @PostMapping ("")
    public ResponseEntity<DoctorResponseDto> createDoctor(@RequestBody final DoctorRequestDto request) {
        return new ResponseEntity<>(doctorService.createDoctor(request), HttpStatus.CREATED);
    }

    @GetMapping ("/{externalId}")
    public ResponseEntity<DoctorResponseDto> getDoctor(@PathVariable ("externalId") final String externalId) {
        return new ResponseEntity<>(doctorService.getDoctor(externalId), HttpStatus.OK);
    }
}
