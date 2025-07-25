package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.repository.AppointmentRepository;
import com.management.HospitalClient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AppointmentService {

    @Autowired
    AppointmentRepository appointmentRepository;

    public AppointmentEntity createAppointment(AppointmentEntity appointmentEntity) {

        return appointmentRepository.save(appointmentEntity);
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
