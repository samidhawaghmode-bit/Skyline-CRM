package com.example.final_crm.controller;

import com.example.final_crm.entity.Lead;
import com.example.final_crm.service.leadService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/lead")
@CrossOrigin
public class leadController {

    private final leadService ls;

    public leadController(leadService ls) {
        this.ls = ls;
    }


    // ADD
    @PostMapping
    public Lead saveLead(@RequestBody Lead lead) {
        return ls.saveLead(lead);
    }


    // DISPLAY ALL
    @GetMapping
    public List<Lead> getAllLeads() {
        return ls.getAllLeads();
    }


    // DISPLAY ONE
    @GetMapping("/{id}")
    public Lead getLeadById(@PathVariable Long id) {
        return ls.getLeadById(id);
    }


    // UPDATE
    @PutMapping("/{id}")
    public Lead updateLead(
            @PathVariable Long id,
            @RequestBody Lead lead) {

        return ls.updateLead(id, lead);
    }


    // DELETE
    @DeleteMapping("/{id}")
    public String deleteLead(@PathVariable Long id) {
        return ls.deleteLead(id);
    }
}