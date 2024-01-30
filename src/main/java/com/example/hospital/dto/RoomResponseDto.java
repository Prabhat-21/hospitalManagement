package com.example.hospital.dto;

import com.example.hospital.entities.Room;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoomResponseDto {
    private String name;

    private String externalId;

    private String hospitalId;

    public RoomResponseDto(Room room) {
        name = room.getName();
        externalId = room.getExternalId();
        hospitalId = room.getHospitalId();
    }
}