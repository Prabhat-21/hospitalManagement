package com.example.hospital.dao;

import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.hospital.entities.Hospital;

@Repository
public interface HospitalRepository extends CrudRepository<Hospital, Long> {
    Optional<Hospital> findByExternalId(String externalId);
}