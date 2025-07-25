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
    @Column(name="prescription_id")
    private Long prescriptionId;
    @Column(name="medicine_name")
    private String medicineName;
    @Column(name="dosage")
    private String appointmentDate;
    @Column(name="duration")
    private int duration;
    @Column(name="frequency")
    private String frequency;
}
