package com.siges.controller;

import com.siges.model.EnseignantModel;
import com.siges.model.SalleModel;
import com.siges.repository.SalleRepository;
import com.siges.service.SalleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SalleController {

    @Autowired(required = false)
    private SalleRepository salleRepository;
    @Autowired
    private SalleService salleService;

    @PostMapping("/addSalle")
    public ResponseEntity<SalleModel> saveSalle(@RequestBody SalleModel salle){

        if (salle == null){
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        SalleModel salleModel = salleRepository.save(salle);
        return new ResponseEntity<>(salleModel, HttpStatus.OK);
    }

    @PutMapping("/updateSalle/{id}")
    public ResponseEntity<SalleModel> updateSalle(@PathVariable("id") String id, @RequestBody SalleModel salleModel){

        return new ResponseEntity<>(salleService.updateSalle(id, salleModel), HttpStatus.OK);
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
