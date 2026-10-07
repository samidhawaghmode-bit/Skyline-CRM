package com.example.final_crm.repository;

import com.example.final_crm.entity.VendorPayment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface vendorPaymentRepository extends JpaRepository<VendorPayment , Long> {
}
