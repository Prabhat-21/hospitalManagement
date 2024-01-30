package com.example.hospital.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.hospital.dto.AdmissionRequestDto;
import com.example.hospital.dto.AdmissionResponseDto;
import com.example.hospital.dto.AdmittedPatientResponseDto;
import com.example.hospital.dto.DischargeRequestDto;

@Service
public interface AdmissionService {
    AdmissionResponseDto admitPatient(AdmissionRequestDto requestDto);

    AdmissionResponseDto dischargePatient(DischargeRequestDto requestDto);

    List<AdmittedPatientResponseDto> fetchAdmittedPatients(String hospitalId);
}

