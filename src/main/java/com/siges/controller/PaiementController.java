package com.siges.controller;

import com.siges.model.PaiementModel;
import com.siges.repository.PaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PaiementController {
    @Autowired(required = false)
    private PaiementRepository paiementRepository;

    @PostMapping("/addPayment")
    public String savePaiement(@RequestBody PaiementModel paiement){
        paiementRepository.save(paiement);
        return "Added Successfully";
    }

    @GetMapping("/findAllPayments")
    public List<PaiementModel> getAllPaiements() {
        return paiementRepository.findAll();
    }

    @DeleteMapping("/deletePayment/{id}")
    public String deletePaiement(@PathVariable String id){
        paiementRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
