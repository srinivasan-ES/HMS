package com.management.HospitalClient.controller;

import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.service.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class PatientController {

    private static final Logger logger= LoggerFactory.getLogger(PatientController.class);

    @Autowired
    PatientService patientService;

    @PostMapping("/create-patient")
    public PatientEntity saveOrUpdate(@RequestBody PatientEntity patientEntity){

        return patientService.createPatient(patientEntity);
    }

    @GetMapping("/get-patient/{id}")
    public PatientEntity getPatient(@PathVariable long id ){
        return patientService.getPatient(id);
    }

    @GetMapping("/get-patients")
    public List<PatientEntity> getPatientList(){
        return patientService.getPatientList();
    }

    @DeleteMapping("/delete-patient/{id}")
    public String deletePatient(@PathVariable Long id){
        patientService.deletePatient(id);
        return "Success";
    }

    @GetMapping("/get-patient/phone-number/{phoneNumber}")
    public PatientEntity getPatientByPhoneNumber(@PathVariable String phoneNumber ){
        return patientService.getPatientByPhoneNumber(phoneNumber);
    }
}
