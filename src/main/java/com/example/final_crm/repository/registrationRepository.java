package com.example.final_crm.repository;

import com.example.final_crm.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface registrationRepository extends JpaRepository<Admin, Long> {

    Optional<Admin> findByUsername(String username);
}