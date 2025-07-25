package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.MedicineEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import com.management.HospitalClient.repository.MedicationRepository;
import com.management.HospitalClient.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicationService {

    @Autowired
    MedicationRepository medicationRepository;

    public MedicineEntity createPrescription(MedicineEntity medicineEntity) {
        return medicationRepository.save(medicineEntity);
    }

    public MedicineEntity getMedicine(long id) {
        return medicationRepository.findById(id).orElse(new MedicineEntity());
    }

    public MedicineEntity getMedicineById(long id) {
        return medicationRepository.findByprescriptionId(id);
    }

    public void deleteMedicine(long id) {
        medicationRepository.deleteById(id);
    }

    public List<MedicineEntity> getMedicineList() {
        return medicationRepository.findAll();
    }

}
