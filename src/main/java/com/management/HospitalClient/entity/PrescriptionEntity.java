package com.management.HospitalClient.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

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
    @OneToMany(mappedBy = "prescription", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<MedicineEntity> medicineEntityList;

    public long getPrescriptionId() {
        return prescriptionId;
    }

    public void setPrescriptionId(long prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getPrescribedDate() {
        return prescribedDate;
    }

    public void setPrescribedDate(String prescribedDate) {
        this.prescribedDate = prescribedDate;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public List<MedicineEntity> getMedicineEntityList() {
        return medicineEntityList;
    }

    public void setMedicineEntityList(List<MedicineEntity> medicineEntityList) {
        this.medicineEntityList = medicineEntityList;
    }
}
