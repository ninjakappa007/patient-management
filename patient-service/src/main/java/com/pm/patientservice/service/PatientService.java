package com.pm.patientservice.service;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PatientService {
    private final PatientRepository patientRepository;

    @Autowired
    PatientService(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

// get patient obj from repo layer and convert patient objs to DTO with helper method
    public List<PatientResponseDTO> getPatients(){

        List<Patient> patientList = patientRepository.findAll();

        return patientList.stream().map(PatientMapper::convertToDTO).toList();
    }

//    get patient dto then convert it to patient obj then return dto
    public PatientResponseDTO cretePatient(PatientRequestDTO patientRequestDTO){
//      Checking if email already exists in database
        if (patientRepository.existsByEmail(patientRequestDTO.getEmail())){
            throw new EmailAlreadyExistsException("A patient with this email already exists" + patientRequestDTO.getEmail());
        }

        Patient newPatient = patientRepository.save(PatientMapper.convertDTOToObj(patientRequestDTO));
        return PatientMapper.convertToDTO(newPatient);
    }
}
