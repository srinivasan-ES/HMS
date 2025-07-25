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
@Table(name = "Appointment_Entity")
public class AppointmentEntity implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "appointment_seq_gen")
    @SequenceGenerator(
            name = "appointment_seq_gen",
            sequenceName = "appointment_seq",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name="appointment_id")
    private long appointmentId;
    @Column(name="patient_id")
    private Long parentId;
    @Column(name="doctor_id")
    private Long doctorId;
    @Column(name="appointment_date")
    private String appointmentDate;
    @Column(name="appointment_time")
    private String appointmentTime;
    @Column(name="status")
    private String status;
    @Column(name="notes")
    private String notes;
}
