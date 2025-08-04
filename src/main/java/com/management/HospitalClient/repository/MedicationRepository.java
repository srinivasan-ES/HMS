package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.MedicineEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicationRepository extends JpaRepository<MedicineEntity,Long> {
}
