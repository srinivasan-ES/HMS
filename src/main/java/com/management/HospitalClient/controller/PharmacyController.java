package com.management.HospitalClient.controller;

import com.management.HospitalClient.entity.AppointmentEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import com.management.HospitalClient.service.AppointmentService;
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
public class PharmacyController {

    private static final Logger logger = LoggerFactory.getLogger(PharmacyController.class);

    @Autowired
    PrescriptionService prescriptionService;

    @PostMapping("/add-prescription")
    public PrescriptionEntity saveOrUpdate(@RequestBody PrescriptionEntity prescriptionEntity) {
        return prescriptionService.createPrescription(prescriptionEntity);
    }

    @GetMapping("/get-prescription/{id}")
    public PrescriptionEntity getPrescription(@PathVariable long id) {
        return prescriptionService.getPrescription(id);
    }

    @GetMapping("/get-prescription/{appointmentId}")
    public PrescriptionEntity getPrescriptionId(@PathVariable long appointmentId) {
        return prescriptionService.getPrescriptionById(appointmentId);
    }

    @DeleteMapping("/cancel-prescription/{id}")
    public String deletePrescription(@PathVariable Long id) {
        prescriptionService.deletePrescription(id);
        return "Success";
    }

}
