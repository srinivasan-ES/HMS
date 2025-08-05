package com.management.HospitalClient.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Entity
@Table(name = "Medication_Entity")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "medicationId")
public class MedicineEntity extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Medication_seq_gen")
    @SequenceGenerator(
            name = "Medication_seq_gen",
            sequenceName = "Medication_seq",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name = "medication_id")
    private long medicationId;
    private Integer quantity;
    private String frequency;
    @ManyToOne
    private MedicineVariantEntity medicineVariantEntity;
    @ManyToOne
    @JsonBackReference
    private PrescriptionEntity prescription;

    public long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(long medicationId) {
        this.medicationId = medicationId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public MedicineVariantEntity getMedicineVariantEntity() {
        return medicineVariantEntity;
    }

    public void setMedicineVariantEntity(MedicineVariantEntity medicineVariantEntity) {
        this.medicineVariantEntity = medicineVariantEntity;
    }

    public PrescriptionEntity getPrescriptionEntity() {
        return prescription;
    }

    public void setPrescriptionEntity(PrescriptionEntity prescriptionEntity) {
        this.prescription = prescriptionEntity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public PrescriptionEntity getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionEntity prescription) {
        this.prescription = prescription;
    }
}
