package com.siges.controller;

import com.siges.model.TypePaiementModel;
import com.siges.repository.TypePaiementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TypePaiementController {
    @Autowired(required = false)
    private TypePaiementRepository typePaiementRepository;

    @PostMapping("/addTypePayment")
    public String saveTypePaiement(@RequestBody TypePaiementModel typePaiement){
        typePaiementRepository.save(typePaiement);
        return "Added Successfully";
    }

    @GetMapping("/findAllTypePayments")
    public List<TypePaiementModel> getAllTypePaiements() {
        return typePaiementRepository.findAll();
    }

    @DeleteMapping("/deleteTypePayment/{id}")
    public String deleteTypePaiement(@PathVariable String id){
        typePaiementRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
