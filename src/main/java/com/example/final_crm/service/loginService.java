package com.example.final_crm.service;

import com.example.final_crm.dto.LoginResponse;
import com.example.final_crm.entity.Admin;
import com.example.final_crm.repository.loginRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class loginService {

    private final loginRepository lr;

    public loginService(loginRepository lr) {
        this.lr = lr;
    }

    public LoginResponse login(String username, String password) {



        Optional<Admin> admin =
                lr.findByUsernameAndPassword(username, password);

        if (admin.isPresent()) {

            return new LoginResponse(
                    true,
                    admin.get().getRole()
            );
        }

        return new LoginResponse(
                false,
                null
        );
    }
    public List<Admin> getAllUsers() {
        return lr.findAll();
    }

    public void deleteUser(Long id) {
        lr.deleteById(id);
    }

    public Admin updateUser(Long id, Admin request) {

        Optional<Admin> existingUser =
                lr.findById(id);

        if (existingUser.isPresent()) {

            Admin user = existingUser.get();

            user.setUsername(request.getUsername());
            user.setRole(request.getRole());

            return lr.save(user);
        }

        return null;
    }
}