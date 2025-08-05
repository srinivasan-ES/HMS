package com.management.HospitalClient.service;

import com.management.HospitalClient.dto.AddMedicineMasterRequest;
import com.management.HospitalClient.entity.MedicineEntity;
import com.management.HospitalClient.entity.MedicineMasterEntity;
import com.management.HospitalClient.entity.MedicineVariantEntity;
import com.management.HospitalClient.entity.PrescriptionEntity;
import com.management.HospitalClient.repository.MedicationRepository;
import com.management.HospitalClient.repository.MedicineVariantMasterDataRepository;
import com.management.HospitalClient.repository.PrescriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MedicationService {

    @Autowired
    MedicationRepository medicationRepository;
    @Autowired
    MedicineVariantMasterDataRepository medicineVariantMasterDataRepository;
    public void createPrescription(AddMedicineMasterRequest request) {

            MedicineMasterEntity master = new MedicineMasterEntity();
            master.setMedicineName(request.getMedicineName());

            List<MedicineVariantEntity> variants = request.getVariants().stream().map(v -> {
                MedicineVariantEntity variant = new MedicineVariantEntity();
                variant.setDosage(v.getDosage());
                variant.setPrice(v.getPrice());
                variant.setStock(v.getStock());
                variant.setMedicineMasterEntity(master);
                return variant;
            }).collect(Collectors.toList());
            master.setActive(true);
            master.setMedicineVariantEntityList(variants);
            medicineVariantMasterDataRepository.save(master);

    }

    public List<MedicineMasterEntity> getMedicine() {

        List<MedicineMasterEntity> medicineMasterEntities=new ArrayList<>();
        List<MedicineMasterEntity> medicineEntity=medicineVariantMasterDataRepository.findAll();
        for(MedicineMasterEntity master:medicineEntity){
            List<MedicineVariantEntity> variantEntityList=master.getMedicineVariantEntityList().parallelStream()
                    .filter(medicine->medicine.getStock()>0).toList();
            master.setMedicineVariantEntityList(variantEntityList);
            if(!variantEntityList.isEmpty()) medicineMasterEntities.add(master);
        }
        return medicineMasterEntities;
    }

    public void deleteMedicine(long id) {
        medicationRepository.deleteById(id);
    }

    public List<MedicineEntity> getMedicineList() {
        return medicationRepository.findAll();
    }

}
