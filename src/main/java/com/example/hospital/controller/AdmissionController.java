package com.example.hospital.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.hospital.dto.AdmissionRequestDto;
import com.example.hospital.dto.AdmissionResponseDto;
import com.example.hospital.dto.AdmittedPatientResponseDto;
import com.example.hospital.dto.DischargeRequestDto;
import com.example.hospital.service.AdmissionService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping ("/api")
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class AdmissionController {
    private final AdmissionService admissionService;

    @PostMapping ("/patients/{patientId}/admit")
    public ResponseEntity<AdmissionResponseDto> admit(@PathVariable ("patientId") final String patientId,
            @RequestBody final AdmissionRequestDto request) {
        request.setPatientId(patientId);
        return new ResponseEntity<>(admissionService.admitPatient(request), HttpStatus.OK);
    }

    @PostMapping ("/patients/{patientId}/discharge")
    public ResponseEntity<AdmissionResponseDto> discharge(@PathVariable ("patientId") final String patientId,
            @RequestBody final DischargeRequestDto request) {
        request.setPatientId(patientId);
        return new ResponseEntity<>(admissionService.dischargePatient(request), HttpStatus.OK);
    }

    @GetMapping ("/hospitals/{hospitalId}/admitted-patients")
    public ResponseEntity<List<AdmittedPatientResponseDto>> fetchAdmittedPatients(@PathVariable ("hospitalId") String hospitalId) {
        return new ResponseEntity<>(admissionService.fetchAdmittedPatients(hospitalId), HttpStatus.OK);
    }
}
