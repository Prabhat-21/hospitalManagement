package com.example.hospital.entities;

import java.sql.Date;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.hospital.dto.PatientRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name = "patients")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Patient {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private long id;

    private String externalId;

    private String name;

    private Date dob;

    @Enumerated (EnumType.STRING)
    private PatientStatus status;

    private String hospitalId;

    public Patient(PatientRequestDto requestDto) {
        externalId = UUID.randomUUID().toString();
        name = requestDto.getName();
        dob = requestDto.getDob();
        status = PatientStatus.REGISTERED;
        hospitalId = requestDto.getHospitalId();
    }
}
