package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.management.HospitalClient.utility.MailSubjectAndContent.patientRegistration;
import static com.management.HospitalClient.utility.MailSubjectAndContent.patientRegistrationSubject;

@Service
public class PatientService {

    @Autowired
    PatientRepository patientRepository;

    @Autowired
    EmailService emailService;

    public PatientEntity createPatient(PatientEntity patientEntity){

        PatientEntity patientEntity1=patientRepository.save(patientEntity);
        emailService.sendEmail(patientEntity1.getEmailAddress(), patientRegistrationSubject, patientRegistration);
        return patientEntity1;
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
