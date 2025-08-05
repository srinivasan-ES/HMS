package com.management.HospitalClient.controller;

import com.management.HospitalClient.dto.DoctorMasterDataDTO;
import com.management.HospitalClient.entity.DoctorEntity;
import com.management.HospitalClient.entity.DoctorMasterDataEntity;
import com.management.HospitalClient.service.DoctorService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class DoctorController {

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @Autowired
    DoctorService doctorService;

    @PostMapping("/create-doctor")
    public DoctorEntity saveOrUpdate(@RequestBody DoctorEntity doctorEntity) {
        return doctorService.createDoctor(doctorEntity);
    }

    @GetMapping("/get-doctor/{id}")
    public DoctorEntity getDoctor(@PathVariable long id) {
        return doctorService.getDoctor(id);
    }

    @GetMapping("/get-doctors")
    public List<DoctorEntity> getDoctorList() {
        return doctorService.getDoctorList();
    }

    @DeleteMapping("/delete-doctor/{id}")
    public String deleteDoctor(@PathVariable Long id) {
        doctorService.deleteDoctor(id);
        return "Success";
    }

    @GetMapping("/get-doctor/phone-number/{phoneNumber}")
    public DoctorEntity getDoctorByPhoneNumber(@PathVariable String phoneNumber) {
        return doctorService.getDoctorByPhoneNumber(phoneNumber);
    }

    @PostMapping("/add-doctor-master-data")
    public String saveMasterData(@RequestBody DoctorMasterDataDTO doctorMasterDataEntity) {
        return doctorService.addMasterData(doctorMasterDataEntity);
    }
}
