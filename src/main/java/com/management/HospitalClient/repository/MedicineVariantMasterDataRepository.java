package com.management.HospitalClient.repository;

import com.management.HospitalClient.entity.DoctorMasterDataEntity;
import com.management.HospitalClient.entity.MedicineMasterEntity;
import com.management.HospitalClient.entity.MedicineVariantEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface MedicineVariantMasterDataRepository extends JpaRepository<MedicineMasterEntity,Long> {

}
