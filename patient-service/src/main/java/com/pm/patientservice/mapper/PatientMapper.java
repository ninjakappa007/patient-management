package com.pm.patientservice.mapper;

import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.model.Patient;

import java.time.LocalDate;


// Convert patient obj to JSON string
public class PatientMapper {
    public static PatientResponseDTO convertToDTO(Patient patient){
       PatientResponseDTO patientResponseDTO = new PatientResponseDTO();
       patientResponseDTO.setId(patient.getId().toString());
       patientResponseDTO.setName(patient.getName());
       patientResponseDTO.setEmail(patient.getEmail());
       patientResponseDTO.setAddress(patient.getAddress());
       patientResponseDTO.setDateOfBirth(patient.getDateOfBirth().toString());
       patientResponseDTO.setGender(patient.getGender());

       return patientResponseDTO;
    }

    public static Patient convertDTOToObj(PatientRequestDTO patientRequestDTO){
        Patient patient = new Patient();
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setGender(patientRequestDTO.getGender());
//      LocalDate.parse() method in Java is used to obtain an instance of LocalDate from a text string
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));
        patient.setRegisterDate(LocalDate.parse(patientRequestDTO.getRegisterDate()));

        return patient;
    }

}
