package com.example.hospital.dto;

import java.sql.Date;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdmissionRequestDto {
    @JsonIgnore
    private String patientId;

    private String doctorId;

    private String roomId;

    private Date admissionDate;

    private int expense;
}
