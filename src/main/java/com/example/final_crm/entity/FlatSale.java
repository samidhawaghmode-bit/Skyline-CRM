package com.example.final_crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "flat_sale")
public class FlatSale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String saleDate;
    private String customerName;
    private String mobile;
    private String project;
    private String flatNo;
    private String flatType;
    private String saleAmount;
    private String bookingAmount;
    private String paymentMode;
    private String saleStatus;
    private String remarks;


    public Long getId() {
        return id;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getProject() {
        return project;
    }

    public String getFlatNo() {
        return flatNo;
    }

    public String getFlatType() {
        return flatType;
    }

    public String getSaleAmount() {
        return saleAmount;
    }

    public String getBookingAmount() {
        return bookingAmount;
    }

    public String getPaymentMode() {
        return paymentMode;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public String getRemarks() {
        return remarks;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setFlatNo(String flatNo) {
        this.flatNo = flatNo;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public void setSaleAmount(String saleAmount) {
        this.saleAmount = saleAmount;
    }

    public void setBookingAmount(String bookingAmount) {
        this.bookingAmount = bookingAmount;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}