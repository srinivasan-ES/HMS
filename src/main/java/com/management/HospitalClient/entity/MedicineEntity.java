package com.management.HospitalClient.entity;

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
public class MedicineEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Medication_seq_gen")
    @SequenceGenerator(
            name = "Medication_seq_gen",
            sequenceName = "Medication_seq",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name="medication_id")
    private long medicationId;
    @Column(name="medicine_name")
    private String medicineName;
    @Column(name="dosage")
    private String dosage;
    @Column(name="duration")
    private int duration;
    @Column(name="frequency")
    private String frequency;
    @ManyToOne
    @JoinColumn(name = "prescription_id", referencedColumnName = "prescription_id")
    private PrescriptionEntity prescription;

    public long getMedicationId() {
        return medicationId;
    }

    public void setMedicationId(long medicationId) {
        this.medicationId = medicationId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public PrescriptionEntity getPrescription() {
        return prescription;
    }

    public void setPrescription(PrescriptionEntity prescription) {
        this.prescription = prescription;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public PrescriptionEntity getPrescriptionEntity() {
        return prescription;
    }

    public void setPrescriptionEntity(PrescriptionEntity prescriptionEntity) {
        this.prescription = prescriptionEntity;
    }
}
