package com.management.HospitalClient.entity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@Table(name = "Medication_Master")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MedicineMasterEntity extends Auditable implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "Medication_mas_seq_gen")
    @SequenceGenerator(
            name = "Medication_mas_seq_gen",
            sequenceName = "Medication_mas_seq_gen",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name = "id")
    private long id;
    @Column(name = "medicine_name")
    private String medicineName;
    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(mappedBy = "medicineMasterEntity",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MedicineVariantEntity> medicineVariantEntityList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public List<MedicineVariantEntity> getMedicineVariantEntityList() {
        return medicineVariantEntityList;
    }

    public void setMedicineVariantEntityList(List<MedicineVariantEntity> medicineVariantEntityList) {
        this.medicineVariantEntityList = medicineVariantEntityList;
    }
}
