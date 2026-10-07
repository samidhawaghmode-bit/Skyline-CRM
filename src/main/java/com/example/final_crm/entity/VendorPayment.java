package com.example.final_crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "vendor_payment")
public class VendorPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentDate;
    private String vendorName;
    private String vendorType;
    private String project;
    private String particulars;
    private String amount;
    private String paymentMode;
    private String paymentStatus;
    private String remarks;

    public Long getId() {
        return id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVendorType() {
        return vendorType;
    }

    public String getProject() {
        return project;
    }

    public String getParticulars() {
        return particulars;
    }

    public String getAmount() {
        return amount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public void setVendorType(String vendorType) {
        this.vendorType = vendorType;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}