package com.example.hospital.entities;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.hospital.dto.DoctorRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Doctor {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String externalId;

    private String name;

    private String hospitalId;

    public Doctor(DoctorRequestDto requestDto) {
        externalId = UUID.randomUUID().toString();
        name = requestDto.getName();
        hospitalId = requestDto.getHospitalId();
    }
}
