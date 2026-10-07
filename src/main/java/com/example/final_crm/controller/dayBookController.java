package com.example.final_crm.controller;

import com.example.final_crm.entity.DayBook;
import com.example.final_crm.repository.dayBookRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/daybook")
@CrossOrigin
public class dayBookController {

    private final dayBookRepository dr;

    public dayBookController(dayBookRepository dr) {
        this.dr = dr;
    }


    // =========================
    // SAVE DAY BOOK ENTRY
    // =========================

    @PostMapping
    public DayBook saveDayBook(
            @RequestBody DayBook dayBook) {

        return dr.save(dayBook);
    }


    // =========================
    // GET ALL DAY BOOK ENTRIES
    // =========================

    @GetMapping
    public List<DayBook> getAllDayBooks() {

        return dr.findAll();
    }


    // =========================
    // GET DAY BOOK BY ID
    // =========================

    @GetMapping("/{id}")
    public DayBook getDayBookById(
            @PathVariable Long id) {

        return dr.findById(id)
                .orElse(null);
    }


    // =========================
    // UPDATE DAY BOOK
    // =========================

    @PutMapping("/{id}")
    public DayBook updateDayBook(
            @PathVariable Long id,
            @RequestBody DayBook dayBook) {

        DayBook existingDayBook =
                dr.findById(id).orElse(null);

        if (existingDayBook == null) {
            return null;
        }


        existingDayBook.setTransactionDate(
                dayBook.getTransactionDate()
        );

        existingDayBook.setTransactionType(
                dayBook.getTransactionType()
        );

        existingDayBook.setParticulars(
                dayBook.getParticulars()
        );

        existingDayBook.setReferenceName(
                dayBook.getReferenceName()
        );

        existingDayBook.setAmount(
                dayBook.getAmount()
        );

        existingDayBook.setPaymentMode(
                dayBook.getPaymentMode()
        );

        existingDayBook.setRemarks(
                dayBook.getRemarks()
        );


        return dr.save(existingDayBook);
    }


    // =========================
    // DELETE DAY BOOK
    // =========================

    @DeleteMapping("/{id}")
    public String deleteDayBook(
            @PathVariable Long id) {

        if (!dr.existsById(id)) {
            return "Day Book entry not found";
        }

        dr.deleteById(id);

        return "Day Book entry deleted successfully";
    }
}