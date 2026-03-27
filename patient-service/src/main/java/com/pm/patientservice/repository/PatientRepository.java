package com.pm.patientservice.repository;

import com.pm.patientservice.model.Patient;
import org.jspecify.annotations.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

// Adding @Repository is same as adding @Component, but it helps dev to mark the layer
@Repository
public interface PatientRepository extends JpaRepository<Patient, UUID> {
    boolean existsByEmail(String email);

//    We can define custom queries like this
//    @Query(value = "SELECT * FROM patient WHERE gender != :gender", nativeQuery = true)
//    List<Patient> findPatientsNotOfGender(@Param("gender") String gender);


}
