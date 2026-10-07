package com.example.final_crm.repository;

import com.example.final_crm.entity.FollowUp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface followUpRepository extends JpaRepository<FollowUp, Long> {
}