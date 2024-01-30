package com.example.hospital.service;

import com.example.hospital.dto.PatientRequestDto;
import com.example.hospital.dto.PatientResponseDto;


public interface PatientService {
    PatientResponseDto createPatient(PatientRequestDto requestDto);

    PatientResponseDto getPatient(String externalId);
}
