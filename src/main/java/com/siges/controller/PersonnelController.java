package com.siges.controller;

import com.siges.model.PersonnelModel;
import com.siges.repository.PersonnelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonnelController {
    @Autowired(required = false)
    private PersonnelRepository personnelRepository;

    @GetMapping("/homePersonnel")
    public String hello() {
        return "Hello World to SIGES APP!";
    }

    @PostMapping("/addPersonnel")
    public String savePersonnel(@RequestBody PersonnelModel personnel){
        personnelRepository.save(personnel);
        return "Added Successfully";
    }

    @GetMapping("/findAllPersonnel")
    public List<PersonnelModel> getPersonnel() {
        return personnelRepository.findAll();
    }

    @DeleteMapping("/deletePersonnel/{id}")
    public String deletePersonnel(@PathVariable String id){
        personnelRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
