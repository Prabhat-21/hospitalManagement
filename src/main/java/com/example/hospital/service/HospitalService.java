package com.example.hospital.service;

import com.example.hospital.dto.HospitalRequestDto;
import com.example.hospital.dto.HospitalResponseDto;

public interface HospitalService {
    HospitalResponseDto createHospital(HospitalRequestDto requestDto);

    HospitalResponseDto getHospital(String externalId);
}
