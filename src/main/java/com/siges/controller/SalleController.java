package com.siges.controller;

import com.siges.model.SalleModel;
import com.siges.repository.SalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalleController {

    @Autowired(required = false)
    private SalleRepository salleRepository;

    @GetMapping("/homeSalle")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addSalle")
    public String saveSalle(@RequestBody SalleModel salle){
        salleRepository.save(salle);
        return "Added Successfully";
    }

    @GetMapping("/findAllSalle")
    public List<SalleModel> getSalles() {
        return salleRepository.findAll();
    }

    @DeleteMapping("/deleteSalle/{id}")
    public String deleteSalle(@PathVariable String id){
        salleRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
