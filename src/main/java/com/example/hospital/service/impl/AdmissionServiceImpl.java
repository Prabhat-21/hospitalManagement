package com.example.hospital.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.hospital.dao.AdmissionRepository;
import com.example.hospital.dao.DoctorRepository;
import com.example.hospital.dao.PatientRepository;
import com.example.hospital.dao.RoomRepository;
import com.example.hospital.dto.AdmissionRequestDto;
import com.example.hospital.dto.AdmissionResponseDto;
import com.example.hospital.dto.AdmittedPatientResponseDto;
import com.example.hospital.dto.DischargeRequestDto;
import com.example.hospital.entities.Admission;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.PatientStatus;
import com.example.hospital.error.Error;
import com.example.hospital.service.AdmissionService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor (onConstructor_ = { @Autowired })
public class AdmissionServiceImpl implements AdmissionService {
    private final AdmissionRepository admissionRepository;

    private final PatientRepository patientRepository;

    private final RoomRepository roomRepository;

    private final DoctorRepository doctorRepository;

    @Override
    public AdmissionResponseDto admitPatient(AdmissionRequestDto requestDto) {
        doctorRepository.findByExternalId(requestDto.getDoctorId()).orElseThrow(Error.DOCTOR_NOT_FOUND.getBuilder()::build);
        roomRepository.findByExternalId(requestDto.getRoomId()).orElseThrow(Error.ROOM_NOT_FOUND.getBuilder()::build);
        final Patient patient = patientRepository.findByExternalId(requestDto.getPatientId())
                                                 .orElseThrow(Error.PATIENT_NOT_FOUND.getBuilder()::build);
        if (PatientStatus.ADMITTED == patient.getStatus()) {
            throw Error.PATIENT_ALREADY_ADMITTED.getBuilder().build();
        }
        final Admission admission = new Admission(requestDto);
        admissionRepository.save(admission);
        patient.setStatus(PatientStatus.ADMITTED);
        patientRepository.save(patient);
        return new AdmissionResponseDto(admission);
    }

    @Override
    public AdmissionResponseDto dischargePatient(DischargeRequestDto requestDto) {
        final Patient patient = patientRepository.findByExternalId(requestDto.getPatientId())
                                                 .orElseThrow(Error.PATIENT_NOT_FOUND.getBuilder()::build);
        if (PatientStatus.ADMITTED != patient.getStatus()) {
            throw Error.PATIENT_NOT_ADMITTED.getBuilder().build();
        }
        final Admission admission = admissionRepository.findByPatientIdAndDischargeDateIsNull(patient.getExternalId())
                                                       .orElseThrow(Error.PATIENT_NOT_ADMITTED.getBuilder()::build);
        patient.setStatus(PatientStatus.DISCHARGED);
        patientRepository.save(patient);
        admission.setDischargeDate(requestDto.getDischargeDate());
        admissionRepository.save(admission);
        return new AdmissionResponseDto(admission);
    }

    @Override
    public List<AdmittedPatientResponseDto> fetchAdmittedPatients(String hospitalId) {
        final List<Patient> patients = patientRepository.findByHospitalIdAndStatus(hospitalId, PatientStatus.ADMITTED);
        if (patients.isEmpty()) {
            return Collections.emptyList();
        }
        final List<String> patientIds = patients.stream().map(Patient::getExternalId).collect(Collectors.toList());
        final Map<String, Admission> admissions = admissionRepository.findByPatientIdInAndDischargeDateIsNull(patientIds).stream()
                                                                     .collect(Collectors.toMap(Admission::getPatientId, Function.identity()));
        return patients.stream().filter(patient -> admissions.containsKey(patient.getExternalId()))
                       .map(patient -> buildAdmittedPatientResponse(patient, admissions.get(patient.getExternalId()))).collect(Collectors.toList());
    }

    private AdmittedPatientResponseDto buildAdmittedPatientResponse(final Patient patient, final Admission admission) {
        return AdmittedPatientResponseDto.builder().patientId(patient.getExternalId()).dob(patient.getDob()).name(patient.getName())
                                         .roomId(admission.getRoomId()).doctorId(admission.getDoctorId()).admissionDate(admission.getAdmissionDate())
                                         .expense(admission.getExpense()).build();
    }
}
