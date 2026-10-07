package com.example.final_crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "enquiry")
public class Enquiry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enquiryDate;

    private String enquiryNo;

    private String project;

    private String flatType;

    private String customerName;

    private String mobile;

    private String budget;

    private String source;

    private String preferredLocation;

    private String bedrooms;

    private String purpose;

    private String enquiryType;


    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getEnquiryDate() {
        return enquiryDate;
    }

    public String getEnquiryNo() {
        return enquiryNo;
    }

    public String getProject() {
        return project;
    }

    public String getFlatType() {
        return flatType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getBudget() {
        return budget;
    }

    public String getSource() {
        return source;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public String getBedrooms() {
        return bedrooms;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getEnquiryType() {
        return enquiryType;
    }


    // =========================
    // SETTERS
    // =========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnquiryDate(String enquiryDate) {
        this.enquiryDate = enquiryDate;
    }

    public void setEnquiryNo(String enquiryNo) {
        this.enquiryNo = enquiryNo;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setBudget(String budget) {
        this.budget = budget;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public void setBedrooms(String bedrooms) {
        this.bedrooms = bedrooms;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setEnquiryType(String enquiryType) {
        this.enquiryType = enquiryType;
    }
}