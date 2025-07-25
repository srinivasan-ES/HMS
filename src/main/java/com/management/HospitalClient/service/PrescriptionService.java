package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import com.management.HospitalClient.repository.AppointmentRepository;
import com.management.HospitalClient.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepository;

    public PrescriptionEntity createPrescription(PrescriptionEntity prescriptionEntity) {
        return prescriptionRepository.save(prescriptionEntity);
    }

    public PrescriptionEntity getPrescription(long id) {
        return prescriptionRepository.findById(id).orElse(new PrescriptionEntity());
    }

    public PrescriptionEntity getPrescriptionById(long id) {
        return prescriptionRepository.findByAppointmentId(id);
    }

    public void deletePrescription(long id) {
        prescriptionRepository.deleteById(id);
    }

    public List<PrescriptionEntity> getPrescriptionList() {
        return prescriptionRepository.findAll();
    }

}
