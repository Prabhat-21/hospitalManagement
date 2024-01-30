package com.example.hospital.dto;

import java.sql.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmittedPatientResponseDto {
    private String name;

    private Date dob;

    private String roomId;

    private String patientId;

    private String doctorId;

    private Date admissionDate;

    private int expense;
}
