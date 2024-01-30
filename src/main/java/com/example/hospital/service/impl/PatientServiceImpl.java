package com.example.hospital.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.dao.HospitalRepository;
import com.example.hospital.dao.PatientRepository;
import com.example.hospital.dto.PatientRequestDto;
import com.example.hospital.dto.PatientResponseDto;
import com.example.hospital.entities.Patient;
import com.example.hospital.error.Error;
import com.example.hospital.service.PatientService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class PatientServiceImpl implements PatientService {
    private final PatientRepository patientRepository;

    private final HospitalRepository hospitalRepository;

    @Override
    public PatientResponseDto createPatient(PatientRequestDto requestDto) {
        final Patient patient = new Patient(requestDto);
        hospitalRepository.findByExternalId(patient.getHospitalId()).orElseThrow(Error.HOSPITAL_NOT_FOUND.getBuilder()::build);
        patientRepository.save(patient);
        return new PatientResponseDto(patient);
    }

    @Override
    public PatientResponseDto getPatient(String externalId) {
        final Patient patient = patientRepository.findByExternalId(externalId).orElseThrow(Error.PATIENT_NOT_FOUND.getBuilder()::build);
        return new PatientResponseDto(patient);
    }
}
