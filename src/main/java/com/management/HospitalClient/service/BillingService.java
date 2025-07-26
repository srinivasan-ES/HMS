package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.BillingEntity;
import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.repository.BillingRepository;
import com.management.HospitalClient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

import static com.management.HospitalClient.utility.MailSubjectAndContent.billingCompletion;
import static com.management.HospitalClient.utility.MailSubjectAndContent.billingCompletionSubject;

@Service
public class BillingService {

    @Autowired
    BillingRepository billingRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    EmailService emailService;

    public BillingEntity createBilling(Long patientId,BillingEntity billingEntity){

        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        billingEntity.setPatient(patient);
        billingEntity.setBillingDate(LocalDate.now().toString());
        BillingEntity billingEntity1= billingRepository.save(billingEntity);
        emailService.sendEmail(patient.getEmailAddress(), billingCompletionSubject, billingCompletion);
        return billingEntity1;
    }

    public BillingEntity getBilling(long id){

        return billingRepository.findById(id).orElse(new BillingEntity());
    }
    public void deleteBilling(long id){

        billingRepository.deleteById(id);
    }
    public List<BillingEntity> getBillingList(){

        return billingRepository.findAll();
    }
}
