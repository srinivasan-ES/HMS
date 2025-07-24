package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorRepository extends JpaRepository<DoctorEntity,Long> {
    DoctorEntity findByPhoneNumber(String phoneNumber);
}
