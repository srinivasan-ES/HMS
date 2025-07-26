package com.management.HospitalClient.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "Appointment_Entity")
public class AppointmentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq_gen")
    @SequenceGenerator(
            name = "appointment_seq_gen",
            sequenceName = "appointment_seq",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name = "appointment_id")
    private long appointmentId;
    @Column(name = "doctor_id")
    private Long doctorId;
    @Column(name = "appointment_date")
    private String appointmentDate;
    @Column(name = "appointment_time")
    private String appointmentTime;
    @Column(name = "status")
    private String status;
    @Column(name = "notes")
    private String notes;
    @OneToOne
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_Id")
    private PatientEntity patient;

    public long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public Long getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Long doctorId) {
        this.doctorId = doctorId;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public PatientEntity getPatient() {
        return patient;
    }

    public void setPatient(PatientEntity patient) {
        this.patient = patient;
    }
}
