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
@Table(name = "patient_entity")
public class PatientEntity  implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "patient_seq_gen")
    @SequenceGenerator(
            name = "patient_seq_gen",
            sequenceName = "patient_seq",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name="patient_id")
    private long patientId;
    @Column(name="name")
    private String name;
    @Column(name="phone-number")
    private String phoneNumber;
}
