package com.management.HospitalClient.service;

import com.management.HospitalClient.dto.DoctorMasterDataDTO;
import com.management.HospitalClient.entity.DoctorEntity;
import com.management.HospitalClient.entity.DoctorMasterDataEntity;
import com.management.HospitalClient.repository.DoctorMasterDataRepository;
import com.management.HospitalClient.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    @Autowired
    DoctorRepository doctorRepository;

    @Autowired
    DoctorMasterDataRepository doctorMasterDataRepository;

    public DoctorEntity createDoctor(DoctorEntity doctorEntity) {

        return doctorRepository.save(doctorEntity);
    }

    public DoctorEntity getDoctor(long id) {

        return doctorRepository.findById(id).orElse(new DoctorEntity());
    }

    public void deleteDoctor(long id) {

        doctorRepository.deleteById(id);
    }

    public List<DoctorEntity> getDoctorList() {

        return doctorRepository.findAll();
    }

    public DoctorEntity getDoctorByPhoneNumber(String phoneNumber) {
        return doctorRepository.findByPhoneNumber(phoneNumber);
    }

    public String addMasterData(DoctorMasterDataDTO doctorMasterDataEntity) {

        DoctorEntity doctorEntity=doctorRepository.findById(doctorMasterDataEntity.getDoctorId()).orElse(new DoctorEntity());
        DoctorMasterDataEntity doctorMasterDataEntity1=new DoctorMasterDataEntity();
        doctorMasterDataEntity1.setDoctor(doctorEntity);
        doctorMasterDataEntity1.setActive(doctorMasterDataEntity.isActive());
        doctorMasterDataEntity1.setSpeciality(doctorMasterDataEntity.getSpeciality());
        doctorMasterDataEntity1.setConsultationFees(doctorMasterDataEntity.getConsultationFees());
        doctorMasterDataEntity1.setConsultationType(doctorMasterDataEntity.getConsultationType());
        doctorMasterDataRepository.save(doctorMasterDataEntity1);
        return "Successfully registered the data";
    }
}
