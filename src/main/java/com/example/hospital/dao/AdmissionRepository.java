package com.example.hospital.dao;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.hospital.entities.Admission;

@Repository
public interface AdmissionRepository extends JpaRepository<Admission, Long> {
    Optional<Admission> findByPatientIdAndDischargeDateIsNull(String patientId);

    List<Admission> findByPatientIdInAndDischargeDateIsNull(final List<String> patientIds);
}
