package com.example.hospital.entities;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.example.hospital.dto.RoomRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table (name = "rooms")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    private String externalId;

    private String name;

    private String hospitalId;

    public Room(RoomRequestDto requestDto) {
        name = requestDto.getName();
        externalId = UUID.randomUUID().toString();
        hospitalId = requestDto.getHospitalId();
    }
}