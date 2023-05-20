package com.siges.controller;

import com.siges.model.SanctionModel;
import com.siges.repository.SanctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SanctionController {
    @Autowired(required = false)
    private SanctionRepository sanctionRepository;

    @PostMapping("/addSanction")
    public String saveSanction(@RequestBody SanctionModel sanction){
        sanctionRepository.save(sanction);
        return "Added Successfully";
    }

    @GetMapping("/findAllSanctions")
    public List<SanctionModel> getSanctions() {
        return sanctionRepository.findAll();
    }

    @DeleteMapping("/deleteSanction/{id}")
    public String deleteSanction(@PathVariable String id){
        sanctionRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
