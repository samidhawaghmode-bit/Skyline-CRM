package com.example.final_crm.controller;

import com.example.final_crm.dto.LoginResponse;
import com.example.final_crm.entity.Admin;
import com.example.final_crm.service.loginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline")
public class loginController {

    private final loginService ls;

    public loginController(loginService ls) {
        this.ls = ls;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody Admin request) {

        return ls.login(
                request.getUsername(),
                request.getPassword()
        );
    }
    @GetMapping("/users")
    public List<Admin> getAllUsers() {
        return ls.getAllUsers();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        ls.deleteUser(id);
    }
    @PutMapping("/users/{id}")
    public Admin updateUser(
            @PathVariable Long id,
            @RequestBody Admin request) {

        return ls.updateUser(id, request);
    }
}