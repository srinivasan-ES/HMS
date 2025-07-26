package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.repository.AppointmentRepository;
import com.management.HospitalClient.repository.PatientRepository;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

import static com.management.HospitalClient.utility.MailSubjectAndContent.*;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    EmailService emailService;

    public AppointmentEntity createAppointment(Long patientId,AppointmentEntity appointmentEntity) {

        PatientEntity patient = patientRepository.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient not found"));
        String email = patient.getEmailAddress();
        appointmentEntity.setPatient(patient);
        AppointmentEntity appointment = appointmentRepository.save(appointmentEntity);
        emailService.sendEmail(email, appointmentConfirmationSubject, appointmentConfirmation);
        return appointment;
    }

    public AppointmentEntity getAppointment(long id) {

        return appointmentRepository.findById(id).orElse(new AppointmentEntity());
    }

    public void deleteAppointment(long id) {

        appointmentRepository.deleteById(id);
    }

    public List<AppointmentEntity> getAppointmentList() {

        return appointmentRepository.findAll();
    }

}
