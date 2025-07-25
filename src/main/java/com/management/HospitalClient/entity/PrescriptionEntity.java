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
@Table(name = "prescription_Entity")
public class PrescriptionEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "prescription_seq_gen")
    @SequenceGenerator(
            name = "prescription_seq_gen",
            sequenceName = "prescription_seq",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name="prescription_id")
    private long prescriptionId;
    @Column(name="appointment_id")
    private Long appointmentId;
    @Column(name="prescribed_date")
    private String prescribedDate;
    @Column(name="diagnosis")
    private String diagnosis;
    @Column(name="remarks")
    private String remarks;
}
