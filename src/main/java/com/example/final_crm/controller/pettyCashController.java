package com.example.final_crm.controller;

import com.example.final_crm.entity.PettyCash;
import com.example.final_crm.repository.pettyCashRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/pettycash")
@CrossOrigin
public class pettyCashController {

    private final pettyCashRepository pr;

    public pettyCashController(pettyCashRepository pr) {
        this.pr = pr;
    }

    @PostMapping
    public PettyCash savePettyCash(
            @RequestBody PettyCash pettyCash) {

        return pr.save(pettyCash);
    }

    @GetMapping
    public List<PettyCash> getAllPettyCash() {

        return pr.findAll();
    }

    @GetMapping("/{id}")
    public PettyCash getPettyCashById(
            @PathVariable Long id) {

        return pr.findById(id)
                .orElse(null);
    }

    @PutMapping("/{id}")
    public PettyCash updatePettyCash(
            @PathVariable Long id,
            @RequestBody PettyCash pettyCash) {

        PettyCash existingPettyCash =
                pr.findById(id).orElse(null);

        if (existingPettyCash == null) {
            return null;
        }

        existingPettyCash.setTransactionDate(
                pettyCash.getTransactionDate()
        );

        existingPettyCash.setExpenseType(
                pettyCash.getExpenseType()
        );

        existingPettyCash.setParticulars(
                pettyCash.getParticulars()
        );

        existingPettyCash.setPaidTo(
                pettyCash.getPaidTo()
        );

        existingPettyCash.setAmount(
                pettyCash.getAmount()
        );

        existingPettyCash.setPaymentMode(
                pettyCash.getPaymentMode()
        );

        existingPettyCash.setRemarks(
                pettyCash.getRemarks()
        );

        return pr.save(existingPettyCash);
    }

    @DeleteMapping("/{id}")
    public String deletePettyCash(
            @PathVariable Long id) {

        if (!pr.existsById(id)) {
            return "Petty Cash entry not found";
        }

        pr.deleteById(id);

        return "Petty Cash entry deleted successfully";
    }
}