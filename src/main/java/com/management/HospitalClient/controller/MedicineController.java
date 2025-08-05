package com.management.HospitalClient.controller;

import com.management.HospitalClient.dto.AddMedicineMasterRequest;
import com.management.HospitalClient.entity.MedicineEntity;
import com.management.HospitalClient.entity.MedicineMasterEntity;
import com.management.HospitalClient.entity.MedicineVariantEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import com.management.HospitalClient.service.MedicationService;
import com.management.HospitalClient.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1")
@Slf4j
public class MedicineController {

    private static final Logger logger = LoggerFactory.getLogger(MedicineController.class);

    @Autowired
    MedicationService medicationService;

    @PostMapping("/add-medicine")
    public void saveOrUpdate(@RequestBody AddMedicineMasterRequest medicineEntity) {
         medicationService.createPrescription(medicineEntity);
    }

    @GetMapping("/get-medicine")
    public List<MedicineMasterEntity> getMedicine() {
        return medicationService.getMedicine();
    }

    @DeleteMapping("/cancel-medicine/{id}")
    public String deleteMedicine(@PathVariable Long id) {
        medicationService.deleteMedicine(id);
        return "Success";
    }

}
