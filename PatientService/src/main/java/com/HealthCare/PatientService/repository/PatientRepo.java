package com.HealthCare.PatientService.repository;

import com.HealthCare.PatientService.dto.PatientDetailsDto;
import com.HealthCare.PatientService.entity.PatientDetails;
import jakarta.validation.constraints.Email;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  PatientRepo extends JpaRepository<PatientDetails,Integer> {
    Optional<PatientDetails> findByEmail(String email);

    PatientDetails findBypatientName(String patientName);
}
