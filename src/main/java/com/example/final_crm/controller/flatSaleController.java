package com.example.final_crm.controller;

import com.example.final_crm.entity.FlatSale;
import com.example.final_crm.repository.flatSaleRepository;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skyline/dashboard/flatsale")
@CrossOrigin
public class flatSaleController {

    private final flatSaleRepository fr;


    public flatSaleController(flatSaleRepository fr) {
        this.fr = fr;
    }


    // SAVE FLAT SALE

    @PostMapping
    public FlatSale saveFlatSale(
            @RequestBody FlatSale flatSale) {

        return fr.save(flatSale);
    }


    // GET ALL FLAT SALES

    @GetMapping
    public List<FlatSale> getAllFlatSales() {

        return fr.findAll();
    }


    // GET FLAT SALE BY ID

    @GetMapping("/{id}")
    public FlatSale getFlatSaleById(
            @PathVariable Long id) {

        return fr.findById(id).orElse(null);
    }


    // UPDATE FLAT SALE

    @PutMapping("/{id}")
    public FlatSale updateFlatSale(
            @PathVariable Long id,
            @RequestBody FlatSale flatSale) {

        FlatSale existingFlatSale =
                fr.findById(id).orElse(null);


        if (existingFlatSale == null) {
            return null;
        }


        existingFlatSale.setSaleDate(
                flatSale.getSaleDate());

        existingFlatSale.setCustomerName(
                flatSale.getCustomerName());

        existingFlatSale.setMobile(
                flatSale.getMobile());

        existingFlatSale.setProject(
                flatSale.getProject());

        existingFlatSale.setFlatNo(
                flatSale.getFlatNo());

        existingFlatSale.setFlatType(
                flatSale.getFlatType());

        existingFlatSale.setSaleAmount(
                flatSale.getSaleAmount());

        existingFlatSale.setBookingAmount(
                flatSale.getBookingAmount());

        existingFlatSale.setPaymentMode(
                flatSale.getPaymentMode());

        existingFlatSale.setSaleStatus(
                flatSale.getSaleStatus());

        existingFlatSale.setRemarks(
                flatSale.getRemarks());


        return fr.save(existingFlatSale);
    }


    // DELETE FLAT SALE

    @DeleteMapping("/{id}")
    public String deleteFlatSale(
            @PathVariable Long id) {

        if (!fr.existsById(id)) {

            return "Flat Sale not found";
        }


        fr.deleteById(id);

        return "Flat Sale deleted successfully";
    }
}