package com.example.hospital.dto;

import com.example.hospital.entities.Hospital;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HospitalResponseDto {
    private String name;

    private String externalId;

    public HospitalResponseDto(Hospital hospital) {
        name = hospital.getName();
        externalId = hospital.getExternalId();
    }
}