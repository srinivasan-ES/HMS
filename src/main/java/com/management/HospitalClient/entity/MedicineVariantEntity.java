package com.management.HospitalClient.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerator;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class MedicineVariantEntity extends Auditable implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "med_var_mas_seq_gen")
    @SequenceGenerator(
            name = "med_var_mas_seq_gen",
            sequenceName = "med_var_mas_seq_gen",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name="id")
    private long id;
    @Column(name="dosage")
    private String dosage;
    @Column(name="price")
    private double price;
    @Column(name="stock")
    private Integer stock;
    @ManyToOne
    @JoinColumn(name = "medicine_master_id")
    @JsonBackReference
    private MedicineMasterEntity medicineMasterEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MedicineMasterEntity getMedicineMasterEntity() {
        return medicineMasterEntity;
    }

    public void setMedicineMasterEntity(MedicineMasterEntity medicineMasterEntity) {
        this.medicineMasterEntity = medicineMasterEntity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDosage() {
        return dosage;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
