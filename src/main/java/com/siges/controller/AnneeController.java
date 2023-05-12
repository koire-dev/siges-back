package com.siges.controller;

import com.siges.model.AnneeModel;
import com.siges.repository.AnneeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;
@RestController
public class AnneeController {

    @Autowired(required = false)
    private  AnneeRepository anneeRepository;

    @GetMapping("/homeYear")
    public String hello() {
        return "Hello World to SIGES APP!";
    }
    @PostMapping("/addYear")
    public String saveCycle(@RequestBody AnneeModel annee){
        anneeRepository.save(annee);
        return "Added Successfully";
    }

    @GetMapping("/findAllYears")
    public List<AnneeModel> getYears() {
        return anneeRepository.findAll();
    }

    @DeleteMapping("/deleteYear/{id}")
    public String deleteYear(@PathVariable String id){
        anneeRepository.deleteById(id);
        return "Deleted Successfully";
    }

}
