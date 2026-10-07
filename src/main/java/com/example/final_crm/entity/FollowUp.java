package com.example.final_crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "follow_up")
public class FollowUp {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String enquiryId;

    private String customerName;

    private String mobile;

    private String followUpType;

    private String followUpDate;

    private String status;

    private String nextFollowUp;


    // =========================
    // GETTERS
    // =========================

    public Long getId() {
        return id;
    }

    public String getEnquiryId() {
        return enquiryId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getFollowUpType() {
        return followUpType;
    }

    public String getFollowUpDate() {
        return followUpDate;
    }

    public String getStatus() {
        return status;
    }

    public String getNextFollowUp() {
        return nextFollowUp;
    }


    // =========================
    // SETTERS
    // =========================

    public void setId(Long id) {
        this.id = id;
    }

    public void setEnquiryId(String enquiryId) {
        this.enquiryId = enquiryId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setFollowUpType(String followUpType) {
        this.followUpType = followUpType;
    }

    public void setFollowUpDate(String followUpDate) {
        this.followUpDate = followUpDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setNextFollowUp(String nextFollowUp) {
        this.nextFollowUp = nextFollowUp;
    }

}