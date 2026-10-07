package com.example.final_crm.repository;

import com.example.final_crm.entity.PettyCash;
import org.springframework.data.jpa.repository.JpaRepository;

public interface pettyCashRepository
        extends JpaRepository<PettyCash, Long> {
}