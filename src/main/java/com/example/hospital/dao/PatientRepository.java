package com.example.hospital.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.example.hospital.entities.Patient;
import com.example.hospital.entities.PatientStatus;

@Repository
public interface PatientRepository extends CrudRepository<Patient, Long> {
    Optional<Patient> findByExternalId(String externalId);

    List<Patient> findByHospitalIdAndStatus(String hospitalId, PatientStatus status);
}
