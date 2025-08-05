package com.management.HospitalClient.service;

import com.management.HospitalClient.dto.AddPrescriptionRequest;
import com.management.HospitalClient.dto.PrescribedMedicineDTO;
import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.MedicineEntity;
import com.management.HospitalClient.entity.MedicineVariantEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import com.management.HospitalClient.repository.AppointmentRepository;
import com.management.HospitalClient.repository.MedicineVariantRepository;
import com.management.HospitalClient.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrescriptionService {

    @Autowired
    PrescriptionRepository prescriptionRepository;
    @Autowired
    AppointmentRepository appointmentRepository;
    @Autowired
    MedicineVariantRepository medicineVariantRepository;
    public PrescriptionEntity createPrescription(AddPrescriptionRequest request) {
        // 1. Get Appointment
        AppointmentEntity appointment = appointmentRepository.findById(request.getAppointmentId())
                .orElse(new AppointmentEntity());

        // 2. Create Prescription
        PrescriptionEntity prescription = new PrescriptionEntity();
        prescription.setPrescribedDate(request.getPrescriptionDate());
        prescription.setDiagnosis(request.getDiagnosis());
        prescription.setRemarks(request.getRemarks());
        prescription.setAppointmentId(request.getAppointmentId());
        List<MedicineEntity> prescribedList = new ArrayList<>();

        // 3. Loop through medicines
        for (PrescribedMedicineDTO dto : request.getMedicines()) {
            MedicineVariantEntity variant = medicineVariantRepository.findById(dto.getVariantId())
                    .orElse(new MedicineVariantEntity());

            MedicineEntity medicine = new MedicineEntity();
            medicine.setMedicineVariantEntity(variant);
            medicine.setFrequency(dto.getFrequency());
            medicine.setQuantity(dto.getQuantity());
            medicine.setPrescription(prescription); // link back
            prescribedList.add(medicine);
        }

        prescription.setMedicines(prescribedList);

        // 4. Save Prescription (Cascade saves medicines)
        return prescriptionRepository.save(prescription);
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
