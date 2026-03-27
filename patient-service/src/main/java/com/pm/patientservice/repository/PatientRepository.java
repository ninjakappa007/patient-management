package com.pm.patientservice.repository;

import com.pm.patientservice.model.Patient;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

// Adding @Repository is same as adding @Component, but it helps dev to mark the layer
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);


}
