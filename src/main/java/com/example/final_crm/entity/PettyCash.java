package com.example.final_crm.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "petty_cash")
public class PettyCash {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String transactionDate;
    private String expenseType;
    private String particulars;
    private String paidTo;
    private String amount;
    private String paymentMode;
    private String remarks;

    public Long getId() {
        return id;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getExpenseType() {
        return expenseType;
    }

    public String getParticulars() {
        return particulars;
    }

    public String getPaidTo() {
        return paidTo;
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

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public void setExpenseType(String expenseType) {
        this.expenseType = expenseType;
    }

    public void setParticulars(String particulars) {
        this.particulars = particulars;
    }

    public void setPaidTo(String paidTo) {
        this.paidTo = paidTo;
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

