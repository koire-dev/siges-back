package com.siges.controller;

import com.siges.model.EleveModel;
import com.siges.repository.EleveRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EleveController {
    @Autowired(required = false)
    private EleveRepository eleveRepository;

    @PostMapping("/addStudent")
    public String saveEleve(@RequestBody EleveModel eleve){
        eleveRepository.save(eleve);
        return "Added Successfully";
    }

    @GetMapping("/findAllStudents")
    public List<EleveModel> getAllEleves() {
        return eleveRepository.findAll();
    }

    @DeleteMapping("/deleteStudent/{id}")
    public String deleteEleve(@PathVariable String id){
        eleveRepository.deleteById(id);
        return "Deleted Successfully";
    }
}
