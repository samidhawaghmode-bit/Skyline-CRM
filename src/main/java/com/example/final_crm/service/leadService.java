package com.example.final_crm.service;

import com.example.final_crm.entity.Lead;
import com.example.final_crm.repository.leadRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class leadService {

    private final leadRepository lr;

    public leadService(leadRepository lr) {
        this.lr = lr;
    }


    // ADD LEAD
    public Lead saveLead(Lead lead) {

        lead.setCreatedDate(
                LocalDate.now()
                        .format(DateTimeFormatter.ofPattern("dd MMM yyyy"))
        );

        Lead savedLead = lr.save(lead);

        // Generate Lead ID after database ID is created
        String generatedLeadId =
                "LD-" +
                        LocalDate.now().format(
                                DateTimeFormatter.ofPattern("ddMMyyyy")
                        ) +
                        "-" +
                        String.format("%03d", savedLead.getId());

        savedLead.setLeadId(generatedLeadId);

        return lr.save(savedLead);
    }


    // GET ALL
    public List<Lead> getAllLeads() {
        return lr.findAll();
    }


    // GET BY ID
    public Lead getLeadById(Long id) {
        return lr.findById(id).orElse(null);
    }


    // UPDATE
    public Lead updateLead(Long id, Lead lead) {

        Lead existingLead =
                lr.findById(id).orElse(null);

        if (existingLead == null) {
            return null;
        }

        existingLead.setEnquiryId(lead.getEnquiryId());
        existingLead.setCustomerName(lead.getCustomerName());
        existingLead.setMobile(lead.getMobile());
        existingLead.setSource(lead.getSource());
        existingLead.setLeadStatus(lead.getLeadStatus());
        existingLead.setAssignTo(lead.getAssignTo());

        return lr.save(existingLead);
    }


    // DELETE
    public String deleteLead(Long id) {

        if (!lr.existsById(id)) {
            return "Lead not found";
        }

        lr.deleteById(id);

        return "Lead deleted successfully";
    }
}