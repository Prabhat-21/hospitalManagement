package com.example.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.dao.HospitalRepository;
import com.example.hospital.dto.HospitalRequestDto;
import com.example.hospital.dto.HospitalResponseDto;
import com.example.hospital.entities.Hospital;
import com.example.hospital.error.Error;
import com.example.hospital.service.HospitalService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Override
    public HospitalResponseDto createHospital(HospitalRequestDto requestDto) {
        final Hospital hospital = new Hospital(requestDto);
        hospitalRepository.save(hospital);
        return new HospitalResponseDto(hospital);
    }

    @Override
    public HospitalResponseDto getHospital(String externalId) {
        final Hospital hospital = hospitalRepository.findByExternalId(externalId).orElseThrow(Error.HOSPITAL_NOT_FOUND.getBuilder()::build);
        return new HospitalResponseDto(hospital);
    }
}
