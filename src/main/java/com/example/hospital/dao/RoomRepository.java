package com.example.hospital.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.hospital.entities.Room;

@Repository
public interface RoomRepository extends CrudRepository<Room, Long> {
    Optional<Room> findByExternalId(String externalId);
}

