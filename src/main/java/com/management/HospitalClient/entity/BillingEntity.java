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
@Table(name = "Billing_Entity")
public class BillingEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "billing_seq_gen")
    @SequenceGenerator(
            name = "billing_seq_gen",
            sequenceName = "billing_seq",   // this is the actual DB sequence name
            allocationSize = 1              // generates one ID at a time
    )
    @Column(name = "billing_id")
    private long billingId;
    @Column(name = "total_amount")
    private double totalAmount;
    @Column(name = "discount")
    private int discount;
    @Column(name = "paid_amount")
    private Long paidAmount;
    @Column(name = "payment_mode")
    private String paymentMode;
    @Column(name = "billing_date")
    private String billingDate;
    @Column(name = "payment_status")
    private String paymentStatus;
    @Column(name = "appointment_id")
    private long appointmentId;
}
