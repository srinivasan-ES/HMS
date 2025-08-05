package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.BillingEntity;
import com.management.HospitalClient.entity.PatientEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface BillingRepository extends JpaRepository<BillingEntity,Long> {

    BillingEntity findByAppointmentId(Long appointmentId);
}
