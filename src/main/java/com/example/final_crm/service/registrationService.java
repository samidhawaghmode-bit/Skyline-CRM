package com.example.final_crm.service;

import com.example.final_crm.entity.Admin;
import com.example.final_crm.repository.registrationRepository;
import org.springframework.stereotype.Service;

@Service
public class registrationService {

    private final registrationRepository rr;

    public registrationService(registrationRepository rr) {
        this.rr = rr;
    }

    public String register(Admin admin) {

        if (rr.findByUsername(admin.getUsername()).isPresent()) {
            return "Username already exists";
        }

        rr.save(admin);

        return "Registration successful";
    }
}