package com.example.final_crm.controller;

import com.example.final_crm.entity.Enquiry;
import com.example.final_crm.entity.FollowUp;
import com.example.final_crm.repository.enquiryRepository;
import com.example.final_crm.repository.followUpRepository;
import com.example.final_crm.entity.Lead;
import com.example.final_crm.repository.leadRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/enquiry")
@CrossOrigin
public class enquiryController {

    private final enquiryRepository er;
    private final followUpRepository fr;
    private final leadRepository lr;


    public enquiryController(
            enquiryRepository er,
            followUpRepository fr, leadRepository lr) {

        this.er = er;
        this.fr = fr;
        this.lr = lr;
    }



    @PostMapping
    public Enquiry saveEnquiry(@RequestBody Enquiry enquiry) {


        Enquiry savedEnquiry = er.save(enquiry);


        FollowUp followUp = new FollowUp();



        followUp.setEnquiryId(
                savedEnquiry.getEnquiryNo()
        );

        followUp.setCustomerName(
                savedEnquiry.getCustomerName()
        );

        followUp.setMobile(
                savedEnquiry.getMobile()
        );


        followUp.setFollowUpType("New Enquiry");

        followUp.setFollowUpDate(
                savedEnquiry.getEnquiryDate()
        );

        followUp.setStatus("Pending");

        followUp.setNextFollowUp("");


        fr.save(followUp);

        // save lead

        Lead lead = new Lead();

        lead.setEnquiryId(
                savedEnquiry.getId()
        );

        lead.setLeadId(
                "L" + savedEnquiry.getId()
        );

        lead.setCustomerName(
                savedEnquiry.getCustomerName()
        );

        lead.setMobile(
                savedEnquiry.getMobile()
        );

        lead.setSource(
                savedEnquiry.getSource()
        );

        lead.setLeadStatus("New");

        lead.setAssignTo("Unassigned");

        lead.setCreatedDate(
                savedEnquiry.getEnquiryDate()
        );

        lr.save(lead);




        return savedEnquiry;
    }



    @GetMapping
    public List<Enquiry> getAllEnquiries() {

        return er.findAll();
    }




    @GetMapping("/{id}")
    public Enquiry getEnquiryById(
            @PathVariable Long id) {

        return er.findById(id)
                .orElse(null);
    }



    @PutMapping("/{id}")
    public Enquiry updateEnquiry(
            @PathVariable Long id,
            @RequestBody Enquiry enquiry) {

        Enquiry existingEnquiry =
                er.findById(id).orElse(null);


        if (existingEnquiry == null) {
            return null;
        }


        existingEnquiry.setEnquiryDate(
                enquiry.getEnquiryDate()
        );

        existingEnquiry.setEnquiryNo(
                enquiry.getEnquiryNo()
        );

        existingEnquiry.setProject(
                enquiry.getProject()
        );

        existingEnquiry.setFlatType(
                enquiry.getFlatType()
        );

        existingEnquiry.setCustomerName(
                enquiry.getCustomerName()
        );

        existingEnquiry.setMobile(
                enquiry.getMobile()
        );

        existingEnquiry.setBudget(
                enquiry.getBudget()
        );

        existingEnquiry.setSource(
                enquiry.getSource()
        );

        existingEnquiry.setPreferredLocation(
                enquiry.getPreferredLocation()
        );

        existingEnquiry.setBedrooms(
                enquiry.getBedrooms()
        );

        existingEnquiry.setPurpose(
                enquiry.getPurpose()
        );

        existingEnquiry.setEnquiryType(
                enquiry.getEnquiryType()
        );


        return er.save(existingEnquiry);
    }



    @DeleteMapping("/{id}")
    public String deleteEnquiry(
            @PathVariable Long id) {

        if (!er.existsById(id)) {

            return "Enquiry not found";
        }


        er.deleteById(id);


        return "Enquiry deleted successfully";
    }
}