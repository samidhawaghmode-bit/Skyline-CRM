package com.example.final_crm.dto;

public class LoginResponse {

    private boolean success;
    private String role;

    public LoginResponse(boolean success, String role) {
        this.success = success;
        this.role = role;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getRole() {
        return role;
    }
}