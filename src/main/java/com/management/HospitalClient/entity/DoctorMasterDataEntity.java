package com.management.HospitalClient.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@Table(name = "doctor_master_data_entity")
public class DoctorMasterDataEntity extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dr_mas_seq_gen")
    @SequenceGenerator(
            name = "dr_mas_seq_gen",
            sequenceName = "dr_mas_seq",
            allocationSize = 1
    )
    @Column(name = "id")
    private long id;
    @Column(name = "consultation_type")
    private String consultationType;
    @Column(name = "consultation_fees")
    private String consultationFees;
    @Column(name = "speciality")
    private String speciality;
    @Column(name = "is_active")
    private boolean isActive;
    @ManyToOne
    @JoinColumn(name="doctor_id")
    @JsonBackReference
    private DoctorEntity doctor;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getConsultationType() {
        return consultationType;
    }

    public void setConsultationType(String consultationType) {
        this.consultationType = consultationType;
    }

    public String getConsultationFees() {
        return consultationFees;
    }

    public void setConsultationFees(String consultationFees) {
        this.consultationFees = consultationFees;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public DoctorEntity getDoctor() {
        return doctor;
    }

    public void setDoctor(DoctorEntity doctor) {
        this.doctor = doctor;
    }
}
