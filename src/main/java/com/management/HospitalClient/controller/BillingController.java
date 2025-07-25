package com.management.HospitalClient.controller;

import com.management.HospitalClient.entity.BillingEntity;
import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.service.BillingService;
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
public class BillingController {

    private static final Logger logger = LoggerFactory.getLogger(BillingController.class);

    @Autowired
    BillingService billingService;

    @PostMapping("/generate-bill")
    public BillingEntity saveOrUpdate(@RequestBody BillingEntity billingEntity) {

        return billingService.createBilling(billingEntity);
    }

    @GetMapping("/get-billing/{id}")
    public BillingEntity getBilling(@PathVariable long id) {
        return billingService.getBilling(id);
    }

    @GetMapping("/get-billings")
    public List<BillingEntity> getBillingList() {
        return billingService.getBillingList();
    }

    @DeleteMapping("/delete-billing/{id}")
    public String deletePatient(@PathVariable Long id) {
        billingService.deleteBilling(id);
        return "Success";
    }


}
