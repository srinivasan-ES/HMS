package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.DoctorMasterDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DoctorMasterDataRepository extends JpaRepository<DoctorMasterDataEntity,Long> {
}
