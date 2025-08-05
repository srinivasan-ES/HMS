package com.management.HospitalClient.dto;

import java.util.List;

public class AddMedicineMasterRequest {

    private String medicineName;
    private List<AddMedicineVariantRequest> variants;

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public List<AddMedicineVariantRequest> getVariants() {
        return variants;
    }

    public void setVariants(List<AddMedicineVariantRequest> variants) {
        this.variants = variants;
    }
}
