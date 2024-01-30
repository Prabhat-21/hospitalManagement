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
import com.example.hospital.dto.HospitalRequestDto;
import com.example.hospital.dto.HospitalResponseDto;
import com.example.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api/hospitals")
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class HospitalController {
    private final HospitalService hospitalService;

    @PostMapping ("")
    public ResponseEntity<HospitalResponseDto> createHospital(@RequestBody final HospitalRequestDto request) {
        return new ResponseEntity<>(hospitalService.createHospital(request), HttpStatus.CREATED);
    }

    @GetMapping ("/{externalId}")
    public ResponseEntity<HospitalResponseDto> getHospital(@PathVariable ("externalId") final String externalId) {
        return new ResponseEntity<>(hospitalService.getHospital(externalId), HttpStatus.OK);
    }
}
