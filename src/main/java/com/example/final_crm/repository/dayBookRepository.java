package com.example.final_crm.repository;

import com.example.final_crm.entity.DayBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface dayBookRepository
        extends JpaRepository<DayBook, Long> {

}