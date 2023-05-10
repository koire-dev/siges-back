package com.siges.controller;

import com.siges.model.AnneeModel;
import com.siges.repository.AnneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnneeController {

    @Autowired
    private AnneeRepository anneeRepository;

    @RequestMapping("/")
    public String home(){
        return "Hello World!";
    }

    @GetMapping("/annee")
    public ResponseEntity<List<AnneeModel>> getAllYears() {
        return ResponseEntity.ok(this.anneeRepository.findAll());
    }

}
