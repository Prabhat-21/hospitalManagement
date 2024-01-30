package com.example.hospital.dto;

import java.sql.Date;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.PatientStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientResponseDto {
    private String externalId;

    private String name;

    private Date dob;

    private PatientStatus status;

    private String hospitalId;

    public PatientResponseDto(Patient patient) {
        externalId = patient.getExternalId();
        name = patient.getName();
        dob = patient.getDob();
        status = patient.getStatus();
        hospitalId = patient.getHospitalId();
    }
}
