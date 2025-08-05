package com.management.HospitalClient.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class AppointmentDTO {

    private String doctorId;
    private String appointmentDate;
    private String appointmentTime;
    private boolean consultationType;
    private long speciality;

    public long getSpeciality() {
        return speciality;
    }

    public void setSpeciality(long speciality) {
        this.speciality = speciality;
    }

    public boolean isConsultationType() {
        return consultationType;
    }

    public void setConsultationType(boolean consultationType) {
        this.consultationType = consultationType;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }
}
