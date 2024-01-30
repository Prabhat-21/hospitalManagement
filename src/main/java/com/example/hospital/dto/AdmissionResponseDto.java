package com.example.hospital.dto;

import java.sql.Date;
import com.example.hospital.entities.Admission;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AdmissionResponseDto {
    private String externalId;

    private String patientId;

    private String doctorId;

    private String roomId;

    private Date admissionDate;

    private Date dischargeDate;

    private int expense;

    public AdmissionResponseDto(Admission admission) {
        externalId = admission.getExternalId();
        patientId = admission.getPatientId();
        doctorId = admission.getDoctorId();
        roomId = admission.getRoomId();
        admissionDate = admission.getAdmissionDate();
        dischargeDate = admission.getDischargeDate();
        expense = admission.getExpense();
    }
}
