package com.example.final_crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_payment")
public class EmployeePayment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String paymentDate;
    private String employeeName;
    private String amount;
    private String paymentMode;
    private String remarks;


    public Long getId() {
        return id;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getAmount() {
        return amount;
    }

    public String getPaymentMode() {
        return paymentMode;
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

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setPaymentMode(String paymentMode) {
        this.paymentMode = paymentMode;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}