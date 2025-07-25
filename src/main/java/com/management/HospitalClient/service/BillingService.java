package com.management.HospitalClient.service;

import com.management.HospitalClient.entity.BillingEntity;
import com.management.HospitalClient.entity.PatientEntity;
import com.management.HospitalClient.repository.BillingRepository;
import com.management.HospitalClient.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillingService {

    @Autowired
    BillingRepository billingRepository;

    public BillingEntity createBilling(BillingEntity billingEntity){

        return billingRepository.save(billingEntity);
    }

    public BillingEntity getBilling(long id){

        return billingRepository.findById(id).orElse(new BillingEntity());
    }
    public void deleteBilling(long id){

        billingRepository.deleteById(id);
    }
    public List<BillingEntity> getBillingList(){

        return billingRepository.findAll();
    }
}
