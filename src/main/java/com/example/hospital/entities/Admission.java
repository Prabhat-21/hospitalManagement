package com.example.hospital.entities;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.hospital.dto.AdmissionRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name = "admissions")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Admission {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String externalId;

    private String patientId;

    private String doctorId;

    private String roomId;

    private Date admissionDate;

    private Date dischargeDate;

    private int expense;

    public Admission(AdmissionRequestDto requestDto) {
        externalId = UUID.randomUUID().toString();
        patientId = requestDto.getPatientId();
        doctorId = requestDto.getDoctorId();
        roomId = requestDto.getRoomId();
        admissionDate = requestDto.getAdmissionDate();
        expense = requestDto.getExpense();
    }
}
