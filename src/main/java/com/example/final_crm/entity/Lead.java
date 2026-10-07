package com.example.final_crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "leads")
public class Lead {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String leadId;

    private Long enquiryId;

    private String customerName;

    private String mobile;

    private String source;

    private String leadStatus;

    private String assignTo;

    private String createdDate;


    public Long getId() {
        return id;
    }

    public String getLeadId() {
        return leadId;
    }

    public Long getEnquiryId() {
        return enquiryId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public String getSource() {
        return source;
    }

    public String getLeadStatus() {
        return leadStatus;
    }

    public String getAssignTo() {
        return assignTo;
    }

    public String getCreatedDate() {
        return createdDate;
    }


    public void setId(Long id) {
        this.id = id;
    }

    public void setLeadId(String leadId) {
        this.leadId = leadId;
    }

    public void setEnquiryId(Long enquiryId) {
        this.enquiryId = enquiryId;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public void setLeadStatus(String leadStatus) {
        this.leadStatus = leadStatus;
    }

    public void setAssignTo(String assignTo) {
        this.assignTo = assignTo;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}