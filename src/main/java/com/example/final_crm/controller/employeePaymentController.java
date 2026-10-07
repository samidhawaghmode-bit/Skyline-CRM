package com.example.final_crm.controller;

import com.example.final_crm.entity.EmployeePayment;
import com.example.final_crm.repository.employeePaymentRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/employeepayment")
@CrossOrigin
public class employeePaymentController {

    private final employeePaymentRepository er;

    public employeePaymentController(
            employeePaymentRepository er) {

        this.er = er;
    }


    @PostMapping
    public EmployeePayment saveEmployeePayment(
            @RequestBody EmployeePayment employeePayment) {

        return er.save(employeePayment);
    }


    @GetMapping
    public List<EmployeePayment> getAllEmployeePayments() {

        return er.findAll();
    }


    @GetMapping("/{id}")
    public EmployeePayment getEmployeePaymentById(
            @PathVariable Long id) {

        return er.findById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public EmployeePayment updateEmployeePayment(
            @PathVariable Long id,
            @RequestBody EmployeePayment employeePayment) {

        EmployeePayment existingPayment =
                er.findById(id).orElse(null);


        if (existingPayment == null) {
            return null;
        }


        existingPayment.setPaymentDate(
                employeePayment.getPaymentDate());

        existingPayment.setEmployeeName(
                employeePayment.getEmployeeName());

        existingPayment.setAmount(
                employeePayment.getAmount());

        existingPayment.setPaymentMode(
                employeePayment.getPaymentMode());

        existingPayment.setRemarks(
                employeePayment.getRemarks());


        return er.save(existingPayment);
    }


    @DeleteMapping("/{id}")
    public String deleteEmployeePayment(
            @PathVariable Long id) {

        if (!er.existsById(id)) {

            return "Employee Payment not found";
        }


        er.deleteById(id);

        return "Employee Payment deleted successfully";
    }
}