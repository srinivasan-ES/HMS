package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.DoctorEntity;
import org.springframework.data.jpa.repository.JpaRepository;



public interface AppointmentRepository extends JpaRepository<AppointmentEntity,Long> {
    AppointmentEntity findByDoctorId(long id);
}
