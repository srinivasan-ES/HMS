package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PatientRepository extends JpaRepository<PatientEntity,Long> {
    PatientEntity findByPhoneNumber(String phoneNumber);
}
