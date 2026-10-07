package com.example.final_crm.controller;

import com.example.final_crm.entity.VendorPayment;
import com.example.final_crm.repository.vendorPaymentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/vendorpayment")
@CrossOrigin
public class vendorPaymentController {

    private final vendorPaymentRepository vr;

    public vendorPaymentController(vendorPaymentRepository vr) {
        this.vr = vr;
    }

    @PostMapping
    public VendorPayment saveVendorPayment(
            @RequestBody VendorPayment vendorPayment) {

        return vr.save(vendorPayment);
    }

    @GetMapping
    public List<VendorPayment> getAllVendorPayments() {

        return vr.findAll();
    }

    @GetMapping("/{id}")
    public VendorPayment getVendorPaymentById(
            @PathVariable Long id) {

        return vr.findById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public VendorPayment updateVendorPayment(
            @PathVariable Long id,
            @RequestBody VendorPayment vendorPayment) {

        VendorPayment existingVendorPayment =
                vr.findById(id).orElse(null);

        if (existingVendorPayment == null) {
            return null;
        }

        existingVendorPayment.setPaymentDate(
                vendorPayment.getPaymentDate());

        existingVendorPayment.setVendorName(
                vendorPayment.getVendorName());

        existingVendorPayment.setVendorType(
                vendorPayment.getVendorType());

        existingVendorPayment.setProject(
                vendorPayment.getProject());

        existingVendorPayment.setParticulars(
                vendorPayment.getParticulars());

        existingVendorPayment.setAmount(
                vendorPayment.getAmount());

        existingVendorPayment.setPaymentMode(
                vendorPayment.getPaymentMode());

        existingVendorPayment.setPaymentStatus(
                vendorPayment.getPaymentStatus());

        existingVendorPayment.setRemarks(
                vendorPayment.getRemarks());

        return vr.save(existingVendorPayment);
    }

    @DeleteMapping("/{id}")
    public String deleteVendorPayment(
            @PathVariable Long id) {

        if (!vr.existsById(id)) {
            return "Vendor Payment not found";
        }

        vr.deleteById(id);

        return "Vendor Payment deleted successfully";
    }
}