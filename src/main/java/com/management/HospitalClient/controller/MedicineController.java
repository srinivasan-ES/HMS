package com.management.HospitalClient.controller;

import com.management.HospitalClient.entity.MedicineEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import com.management.HospitalClient.service.MedicationService;
import com.management.HospitalClient.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class MedicineController {

    private static final Logger logger = LoggerFactory.getLogger(MedicineController.class);

    @Autowired
    MedicationService medicationService;

    @PostMapping("/add-medicine")
    public MedicineEntity saveOrUpdate(@RequestBody MedicineEntity medicineEntity) {
        return medicationService.createPrescription(medicineEntity);
    }

    @GetMapping("/get-medicine/{id}")
    public MedicineEntity getMedicine(@PathVariable long id) {
        return medicationService.getMedicine(id);
    }

    @DeleteMapping("/cancel-medicine/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        medicationService.deleteMedicine(id);
        return "Success";
    }

}
