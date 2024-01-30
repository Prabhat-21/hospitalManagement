package com.example.hospital.service;

import com.example.hospital.dto.DoctorRequestDto;
import com.example.hospital.dto.DoctorResponseDto;

public interface DoctorService {
    DoctorResponseDto createDoctor(DoctorRequestDto requestDto);

    DoctorResponseDto getDoctor(String externalId);
}
