package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public PatientEntity createPatient(PatientEntity patientEntity){

        return patientRepository.save(patientEntity);
    }

    public PatientEntity getPatient(long id){

        return patientRepository.findById(id).orElse(new PatientEntity());
    }
    public void deletePatient(long id){

         patientRepository.deleteById(id);
    }
    public List<PatientEntity> getPatientList(){

        return patientRepository.findAll();
    }
    public PatientEntity getPatientByPhoneNumber(String phoneNumber) {
        return patientRepository.findByPhoneNumber(phoneNumber);
    }
}
