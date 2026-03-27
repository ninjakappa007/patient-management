package com.pm.patientservice.service;
import com.pm.patientservice.dto.PatientRequestDTO;
import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.exception.EmailAlreadyExistsException;
import com.pm.patientservice.exception.PatientNotFoundException;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public PatientResponseDTO updatePatient(UUID id, PatientRequestDTO patientRequestDTO){
//        checking if uuid exists in db
        Patient patient = patientRepository.findById(id).orElseThrow(
                ()-> new PatientNotFoundException("Patient not available with given uuid" + id));

//      checking if email is changed, if changed move to inner-if
        if(!patient.getEmail().equals(patientRequestDTO.getEmail())){
//        checking if email is unique
            if(patientRepository.existsByEmail(patientRequestDTO.getEmail())){
                throw new EmailAlreadyExistsException("A patient with this email already exists" + patientRequestDTO.getEmail());
            }
        }
        patient.setName(patientRequestDTO.getName());
        patient.setEmail(patientRequestDTO.getEmail());
        patient.setAddress(patientRequestDTO.getAddress());
        patient.setGender(patientRequestDTO.getGender());
//      LocalDate.parse() method in Java is used to obtain an instance of LocalDate from a text string
        patient.setDateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()));

        Patient updatedPatient = patientRepository.saveAndFlush(patient);
        return PatientMapper.convertToDTO(updatedPatient);
    }

    public void deletePatient(UUID id){
        patientRepository.findById(id).orElseThrow(()->
                new PatientNotFoundException("Patient not available with given uuid" + id ));
        patientRepository.deleteById(id);
    }
}
