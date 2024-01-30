package com.example.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.dao.DoctorRepository;
import com.example.hospital.dao.HospitalRepository;
import com.example.hospital.dto.DoctorRequestDto;
import com.example.hospital.dto.DoctorResponseDto;
import com.example.hospital.entities.Doctor;
import com.example.hospital.error.Error;
import com.example.hospital.service.DoctorService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class DoctorServiceImpl implements DoctorService {
    private final DoctorRepository doctorRepository;

    private final HospitalRepository hospitalRepository;

    @Override
    public DoctorResponseDto createDoctor(DoctorRequestDto requestDto) {
        final Doctor doctor = new Doctor(requestDto);
        hospitalRepository.findByExternalId(doctor.getHospitalId()).orElseThrow(Error.HOSPITAL_NOT_FOUND.getBuilder()::build);
        doctorRepository.save(doctor);
        return new DoctorResponseDto(doctor);
    }

    @Override
    public DoctorResponseDto getDoctor(String externalId) {
        final Doctor doctor = doctorRepository.findByExternalId(externalId).orElseThrow(Error.DOCTOR_NOT_FOUND.getBuilder()::build);
        return new DoctorResponseDto(doctor);
    }
}