package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.MedicineVariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface MedicineVariantRepository extends JpaRepository<MedicineVariantEntity,Long> {
}
