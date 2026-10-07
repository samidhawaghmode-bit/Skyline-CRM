package com.example.final_crm.controller;

import com.example.final_crm.entity.Admin;
import com.example.final_crm.service.registrationService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/skyline")
public class registrationController {

    private final registrationService rs;

    public registrationController(registrationService rs) {
        this.rs = rs;
    }

    @PostMapping("/register")
    public String register(@RequestBody Admin admin) {

        return rs.register(admin);
    }
}