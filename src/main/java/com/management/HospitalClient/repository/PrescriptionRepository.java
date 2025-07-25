package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity,Long> {
    PrescriptionEntity findByAppointmentId(long id);
}
