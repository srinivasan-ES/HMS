package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.DoctorEntity;
import com.management.HospitalClient.repository.DoctorRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }
    public DoctorEntity createDoctor(DoctorEntity doctorEntity){

        return doctorRepository.save(doctorEntity);
    }

    public DoctorEntity getDoctor(long id){

        return doctorRepository.findById(id).orElse(new DoctorEntity());
    }
    public void deleteDoctor(long id){

        doctorRepository.deleteById(id);
    }
    public List<DoctorEntity> getDoctorList(){

        return doctorRepository.findAll();
    }
    public DoctorEntity getDoctorByPhoneNumber(String phoneNumber) {
        return doctorRepository.findByPhoneNumber(phoneNumber);
    }
}
