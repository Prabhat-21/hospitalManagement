package com.example.hospital.dto;

import com.example.hospital.entities.Doctor;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DoctorResponseDto {
    private String externalId;

    private String name;

    private String hospitalId;

    public DoctorResponseDto(Doctor doctor) {
        externalId = doctor.getExternalId();
        name = doctor.getName();
        hospitalId = doctor.getHospitalId();
    }
}
