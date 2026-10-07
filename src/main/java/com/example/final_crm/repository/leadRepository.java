package com.example.final_crm.repository;

import com.example.final_crm.entity.Lead;
import org.springframework.data.jpa.repository.JpaRepository;

public interface leadRepository extends JpaRepository<Lead, Long> {
}