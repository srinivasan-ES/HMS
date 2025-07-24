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
@Table(name = "doctor_entity")
public class DoctorEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dr_seq_gen")
    @SequenceGenerator(
            name = "dr_seq_gen",
            sequenceName = "dr_seq",
            allocationSize = 1
    )
    @Column(name = "doctor_id")
    private long doctorId;
    @Column(name = "name")
    private String doctorName;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "specialization")
    private String specialization;
    @Column(name = "email")
    private String email;
    @Column(name = "experience_years")
    private String experienceYears;
    @Column(name = "department")
    private String department;
    @Column(name = "availability_status")
    private String availabilityStatus;
}
