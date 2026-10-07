package com.example.final_crm.repository;

import com.example.final_crm.entity.EmployeePayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeePaymentRepository
        extends JpaRepository<EmployeePayment, Long> {
}