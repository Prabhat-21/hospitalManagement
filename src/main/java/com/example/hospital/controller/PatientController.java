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
import com.example.hospital.dto.PatientRequestDto;
import com.example.hospital.dto.PatientResponseDto;
import com.example.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api/patients")
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class PatientController {
    private final PatientService patientService;

    @PostMapping ("")
    public ResponseEntity<PatientResponseDto> createPatient(@RequestBody final PatientRequestDto request) {
        return new ResponseEntity<>(patientService.createPatient(request), HttpStatus.CREATED);
    }

    @GetMapping ("/{externalId}")
    public ResponseEntity<PatientResponseDto> getPatient(@PathVariable ("externalId") final String externalId) {
        return new ResponseEntity<>(patientService.getPatient(externalId), HttpStatus.OK);
    }
}
