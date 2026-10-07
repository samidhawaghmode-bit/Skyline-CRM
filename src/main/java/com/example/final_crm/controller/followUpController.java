package com.example.final_crm.controller;

import com.example.final_crm.entity.FollowUp;
import com.example.final_crm.repository.followUpRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/followup")
@CrossOrigin
public class followUpController {

    private final followUpRepository fr;

    public followUpController(followUpRepository fr) {
        this.fr = fr;
    }



    @PostMapping
    public FollowUp saveFollowUp(@RequestBody FollowUp followUp) {

        return fr.save(followUp);
    }



    @GetMapping
    public List<FollowUp> getAllFollowUps() {

        return fr.findAll();
    }



    @GetMapping("/{id}")
    public FollowUp getFollowUpById(@PathVariable Long id) {

        return fr.findById(id)
                .orElse(null);
    }



    @PutMapping("/{id}")
    public FollowUp updateFollowUp(
            @PathVariable Long id,
            @RequestBody FollowUp followUp) {

        FollowUp existingFollowUp =
                fr.findById(id).orElse(null);

        if (existingFollowUp == null) {
            return null;
        }


        existingFollowUp.setEnquiryId(
                followUp.getEnquiryId()
        );

        existingFollowUp.setCustomerName(
                followUp.getCustomerName()
        );

        existingFollowUp.setMobile(
                followUp.getMobile()
        );

        existingFollowUp.setFollowUpType(
                followUp.getFollowUpType()
        );

        existingFollowUp.setFollowUpDate(
                followUp.getFollowUpDate()
        );

        existingFollowUp.setStatus(
                followUp.getStatus()
        );

        existingFollowUp.setNextFollowUp(
                followUp.getNextFollowUp()
        );


        return fr.save(existingFollowUp);
    }


    @DeleteMapping("/{id}")
    public String deleteFollowUp(@PathVariable Long id) {

        if (!fr.existsById(id)) {

            return "Follow Up not found";
        }

        fr.deleteById(id);

        return "Follow Up deleted successfully";
    }
}