package com.example.final_crm.repository;

import com.example.final_crm.entity.Enquiry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface enquiryRepository extends JpaRepository<Enquiry , Long> {
}
